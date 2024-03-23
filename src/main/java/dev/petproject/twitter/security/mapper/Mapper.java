package dev.petproject.twitter.security.mapper;

public interface Mapper<D, S> {

    D map(S source);
}
