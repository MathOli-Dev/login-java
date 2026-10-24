package com.matholi.login.security;

/** Dados do usuário autenticado, disponíveis nos controllers via @AuthenticationPrincipal. */
public record AuthenticatedUser(Long id, String email) {}
