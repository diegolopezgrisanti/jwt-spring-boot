package com.dalg.springsecurityapp.auth.controller;

public record RegisterRequest(
        String email,
        String password,
        String name
) {
}