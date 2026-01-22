package com.onayquem.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTaskRequest (

    @NotBlank(message = "Título é obrigatório")
    @Size(min = 3, max = 100, message = "Título deve ter entre 3 e 100 caracteres")
    String title,

    @Size (max = 300, message = "Descrição deve ter no máximo 300 caracters")
    String description
) {}
