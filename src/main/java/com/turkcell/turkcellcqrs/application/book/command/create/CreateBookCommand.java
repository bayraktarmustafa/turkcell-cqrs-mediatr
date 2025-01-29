package com.turkcell.turkcellcqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.turkcellcqrs.application.book.mapper.BookMapper;
import com.turkcell.turkcellcqrs.core.pipelines.auth.AuthenticationBehavior;
import com.turkcell.turkcellcqrs.domain.entity.Book;
import com.turkcell.turkcellcqrs.persistence.book.BookRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class CreateBookCommand implements Command<CreatedBookResponse> {

    @NotBlank
    private  String name;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookHandler implements Command.Handler<CreateBookCommand,CreatedBookResponse>
    {
        private final BookRepository bookRepository;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            BookMapper mapper =BookMapper.INSTANCE;
            Book book= mapper.convertCreateCommandToBook(createBookCommand);

            bookRepository.save(book);

            return mapper.convertBookToCreateBookResponse(book);
        }
    }
}
