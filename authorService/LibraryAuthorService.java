package com.example.librarymanagmentsystem.services.authorService;

import com.example.librarymanagmentsystem.Repositories.AuthorRepository;
import com.example.librarymanagmentsystem.exceptions.booksexception.AuthorNotFoundException;
import com.example.librarymanagmentsystem.models.bookModel.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryAuthorService implements AuthorService {
    AuthorRepository authorRepository;

    LibraryAuthorService(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @Override
    public Author getAuthorByName(String name) throws AuthorNotFoundException {
        Author author = authorRepository.findByName(name);
        if (author == null) {
            throw new AuthorNotFoundException("Invalid Author", name);
        }
        return author;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
public Author updateAuthor(Long id, Author newAuthor) throws AuthorNotFoundException {
    Optional<Author> authorOptional = authorRepository.findById(id);
    if (!authorOptional.isPresent()) {
        throw new AuthorNotFoundException("Author with id " + id + " not found", "Exception");
    }
    Author author = authorOptional.get();
    author = update(author, newAuthor);
    return author;
}

    @Override
    public void deleteAuthor(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()) {
            throw new AuthorNotFoundException("with id " + id + " not found", "Exception");
        }
        Author author = authorOptional.get();
        authorRepository.delete(author);
    }

    private Author update(Author author, Author newAuthor) {
        newAuthor.setId(author.getId());
        author.setName(newAuthor.getName());
        author.setDob(newAuthor.getDob());
        authorRepository.save(newAuthor);
        return author;
    }

    @Override
    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()) {
            throw new AuthorNotFoundException("Exception", "Author with id " + id + " not found");
        }
        return authorOptional.get();
    }
}
