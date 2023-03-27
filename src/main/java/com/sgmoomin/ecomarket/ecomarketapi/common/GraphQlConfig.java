package com.sgmoomin.ecomarket.ecomarketapi.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.query.QuerydslDataFetcher;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import com.sgmoomin.ecomarket.ecomarketapi.repository.MemberRepository;

import graphql.scalars.ExtendedScalars;
import graphql.schema.Coercing;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.SchemaDirectiveWiring;

// scalar type 기록
@Configuration
public class GraphQlConfig {

    @Bean
    public GraphQLScalarType Date(){
        return ExtendedScalars.Date;
    }

    // @Bean
    // public GraphQLScalarType Long(){
    //     return ExtendedScalars.GraphQLLong;
    // }
    
    @Bean 
    public RuntimeWiringConfigurer runtimeWiringConfigurer() { 
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Date); 
    }

    // @Bean 
    // public RuntimeWiringConfigurer runtimeWiringConfigurer() { 
    //     return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Long); 
    // }

    //     GraphQLScalarType scalarType = ... ;
    //     SchemaDirectiveWiring directiveWiring = ... ;
    //     DataFetcher dataFetcher = QuerydslDataFetcher.builder(repository).single();

    //     return wiringBuilder -> wiringBuilder
    //             .scalar(scalarType)
    //             .directiveWiring(directiveWiring)
    //             .type("Query", builder -> builder.dataFetcher("book", dataFetcher));
    // }

}