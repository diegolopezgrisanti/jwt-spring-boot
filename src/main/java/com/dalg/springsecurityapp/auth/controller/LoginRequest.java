package com.dalg.springsecurityapp.auth.controller;

public record LoginRequest(
        String email,
        String password
) {
}