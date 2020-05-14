package com.receipe.management.security.model;

import lombok.*;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class UserResponse implements Serializable {
    private static final long serialVersionUID = -65657834537474537L;
    private final String token;
}

