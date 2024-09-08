package com.gauravCoding.restApiExample.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class Person {
  private final String name;
  private final String id;
}
