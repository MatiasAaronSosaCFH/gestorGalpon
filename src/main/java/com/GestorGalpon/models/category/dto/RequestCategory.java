package com.GestorGalpon.models.category.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestCategory(@NotBlank String name) {
}
