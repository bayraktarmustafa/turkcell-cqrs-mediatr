package com.turkcell.turkcellcqrs.core.web;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.repack.com.google.common.io.BaseEncoding;

public class BaseController {
    protected final Pipeline pipeline;

    public BaseController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }
}
