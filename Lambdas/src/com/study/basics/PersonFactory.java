package com.study.basics;

import com.study.models.Person;

public interface PersonFactory {
	Person create(String name, Integer age);
}
