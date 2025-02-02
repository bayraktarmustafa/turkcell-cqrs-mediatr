package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.author.rules.AuthorBusinessRules;
import com.turkcell.turkcellcqrs.application.book.mapper.BookMapper;
import com.turkcell.turkcellcqrs.core.pipelines.auth.AuthenticationBehavior;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
public class CreateBookCommand implements Command<CreatedBookResponse> {

    @NotBlank
    @Size(min = 3)
    private  String name;
    @NotNull
    private UUID authorId;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookHandler implements Command.Handler<CreateBookCommand,CreatedBookResponse>
    {
        private final BookRepository bookRepository;
        private final AuthorBusinessRules authorBusinessRules;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            authorBusinessRules.authorWithIdCanNotBeNull(createBookCommand.authorId);
            BookMapper mapper =BookMapper.INSTANCE;
            Book book= mapper.convertCreateCommandToBook(createBookCommand);
            bookRepository.save(book);

            return mapper.convertBookToCreateBookResponse(book);
        }
    }
}
