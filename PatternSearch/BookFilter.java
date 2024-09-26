package myclass.PatternSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookFilter {

    public static void main(String[] args) {
        // Example data
        List<HashMap<String, String>> authorBookData = new ArrayList<>();
        HashMap<String, String> author1 = new HashMap<>();
        author1.put("author", "John Doe");
        author1.put("book", "The Art of Programming");

        HashMap<String, String> author2 = new HashMap<>();
        author2.put("author", "Jane Smith");
        author2.put("book", "Data Structures and Algorithms");

        authorBookData.add(author1);
        authorBookData.add(author2);

        HashMap<String, String> authorz = authorBookData.get(1);
        System.out.println(authorBookData);

        // Example usage of the filter method
        String bookTitleToFilter = "The Art of Programming";
        List<String> filteredAuthors = filterAuthorsByBookTitle(authorBookData, bookTitleToFilter);

        // Print the filtered authors
        System.out.println("Authors of '" + bookTitleToFilter + "': " + filteredAuthors);
    }

    /**
     * Filter authors based on the given book title.
     *
     * @param authorBookData List of maps containing author-book data.
     * @param bookTitle      Title of the book to filter for.
     * @return List of authors whose books match the given title.
     */
    private static List<String> filterAuthorsByBookTitle(List<HashMap<String, String>> authorBookData, String bookTitle) {
        List<String> filteredAuthors = new ArrayList<>();

        for (Map<String, String> authorBook : authorBookData) {
            String currentBookTitle = authorBook.get("book");

            // Case-insensitive comparison
            if (currentBookTitle != null && currentBookTitle.equalsIgnoreCase(bookTitle)) {
                String currentAuthor = authorBook.get("author");
                if (currentAuthor != null) {
                    filteredAuthors.add(currentAuthor);
                }
            }
        }

        return filteredAuthors;
    }
}
