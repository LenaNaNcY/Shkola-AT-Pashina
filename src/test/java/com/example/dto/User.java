package com.example.dto;

import java.util.UUID;

public record User(UUID id, String name, String password) {
}