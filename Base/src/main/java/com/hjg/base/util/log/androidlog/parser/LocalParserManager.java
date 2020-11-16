package com.hjg.base.util.log.androidlog.parser;

import com.hjg.base.util.log.Parser;

public class LocalParserManager {

    // 默认支持解析库
    public static final Class<? extends Parser>[] DEFAULT_PARSE_CLASS = new Class[]{
            BundleParse.class, IntentParse.class, CollectionParse.class,
            MapParse.class, ThrowableParse.class, ReferenceParse.class, MessageParse.class,
            ActivityParse.class
    };
}
