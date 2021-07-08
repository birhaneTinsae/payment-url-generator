package com.example.rsaencryption.controller;

import com.example.rsaencryption.config.OpenupConfig;
import com.example.rsaencryption.dto.*;
import com.example.rsaencryption.model.OpenAPIRequest;
import com.example.rsaencryption.utils.DigestUtil;
import com.example.rsaencryption.utils.RSAUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@RestController
@Log4j2
//@RequiredArgsConstructor
public class IndexController {
    private static final String APP_KEY = "appKey";
    private final OpenupConfig config;

    public IndexController(OpenupConfig config) {
        this.config = config;
    }

    @PostMapping("/encrypt")
    public OpenAPIRequest encrypt(@RequestBody @Valid EncryptRequestDTO encryptRequestDTO) {
        var data = JSON.toJSONString(encryptRequestDTO);
        SortedMap<String, String> sortedMap = JSON.parseObject(data, new TypeReference<TreeMap<String, String>>() {
        });
        sortedMap.put(APP_KEY, config.getAppkey());
        var sb = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            if (!StringUtils.isEmpty(sb.toString())) {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        String sgin = DigestUtil.toSha256(sb.toString());
        String ussd = RSAUtils.encryptByPublicKey(data, config.getPublickey());
        var request = new OpenAPIRequest();
        request.setAppid(config.getAppid());
        request.setUssd(ussd);
        request.setSign(sgin);
        return  request;
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity(config.getToTradeWebPay(), request, String.class);
//        R<ToTradeWebPayResponse> r = JSON.parseObject(responseEntity.getBody(), new TypeReference<R<ToTradeWebPayResponse>>() {
//        });
//        if (r.getCode() == 200) {
//            return new EncryptResponseDTO(r.getData().getToPayUrl());
//        } else {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Cannot process your request to encrypt");
//        }
    }

//    @PostMapping("/decrypt")
//    public DecryptResponseDTO decrypt(@RequestBody @Valid DecryptRequestDTO decryptRequest) {
//
//    }
}
