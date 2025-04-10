package com.springboot.E_QuickOrd.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoResponseDto(
        Long id,
        LocalDateTime dataHora,
        String status,
        BigDecimal total) {}
