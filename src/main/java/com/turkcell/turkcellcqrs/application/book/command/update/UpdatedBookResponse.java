package com.turkcell.turkcellcqrs.application.book.command.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedBookResponse {
    private UUID id;
    private String name;
}
