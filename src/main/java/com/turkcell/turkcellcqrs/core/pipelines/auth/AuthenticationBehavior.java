package com.turkcell.turkcellcqrs.core.pipelines.auth;

import an.awesome.pipelinr.Command;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationBehavior implements Command.Middleware{

    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {

    }
}
