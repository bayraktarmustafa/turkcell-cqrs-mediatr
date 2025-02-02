package com.turkcell.turkcellcqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.turkcellcqrs.application.cartitem.command.create.CreateCartItemCommand;
import com.turkcell.turkcellcqrs.application.cartitem.command.create.CreatedCartItemResponse;
import com.turkcell.turkcellcqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CartItemsController extends BaseController {
    public CartItemsController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCartItemResponse createCartItem(@RequestBody CreateCartItemCommand command)
    {
        return command.execute(pipeline);
    }
}
