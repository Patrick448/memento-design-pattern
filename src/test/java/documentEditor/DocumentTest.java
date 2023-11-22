package documentEditor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void deveRestaurarDocumento() {
        Document document = new Document("Document", "Content");
        document.setContent("New content");
        document.restore(0);
        assertEquals("Content", document.getContent());
    }

    @Test
    void deveRestaurarDocumento2() {
        Document document = new Document("Document", "Content");
        document.setContent("New content");
        document.setContent("New content 2");
        document.setContent("New content 3");
        document.restore(1);
        assertEquals("New content", document.getContent());
    }

    @Test
    void deveRetornarExcecao() {
        Document document = new Document("Document", "Content");
        document.setContent("New content");
        try {
            document.restore(2);
            fail();
        }catch (IllegalArgumentException e){
            assertEquals("Invalid index.", e.getMessage());
        }
    }
}