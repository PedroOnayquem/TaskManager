package com.onayquem.taskmanager.dto;

public record TaskResponse(

    Long id,
    String title,
    String description,
    boolean completed

) {}
