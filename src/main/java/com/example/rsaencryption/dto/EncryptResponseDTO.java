package com.example.rsaencryption.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncryptResponseDTO implements Serializable {
    private String toPayUrl;
}
