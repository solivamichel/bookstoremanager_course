package com.soliva.bookstoremanager.author.service;

import com.soliva.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.soliva.bookstoremanager.author.dto.AuthorDTO;
import com.soliva.bookstoremanager.author.entity.Author;
import com.soliva.bookstoremanager.author.mapper.AuthorMapper;
import com.soliva.bookstoremanager.author.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder = AuthorDTOBuilder.builder().build();
    }

    @Test
    void whenNewAuthorIsInformedThenItShouldBeCreated() {
        // Given
        AuthorDTO expectedAuthorToCreateDTO = authorDTOBuilder.buildAuthorDTO();
        Author expectedCreatedAuthor = authorMapper.toModel(expectedAuthorToCreateDTO);

        // when
        Mockito.when(authorRepository.save(expectedCreatedAuthor)).thenReturn(expectedCreatedAuthor);

        AuthorDTO createdAuthorDTO = authorService.create(expectedAuthorToCreateDTO);

    }
}
