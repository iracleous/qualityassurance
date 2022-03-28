package gr.codehub.qualityassurance;

import gr.codehub.qualityassurance.model.TodoItem;
import gr.codehub.qualityassurance.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class QualityassuranceApplicationTests {

    @Autowired
    private TodoService todoService;

    @Test
    void insertItemWithNoSaveTest() {
        List<TodoItem> itemsBefore = todoService.findAll();
        todoService.save("dimitris is working");
        List<TodoItem> itemsAfter = todoService.findAll();
        assertEquals(0, itemsAfter.size()-itemsBefore.size());
    }


    @Test
    void insertItemTest() {
        List<TodoItem> itemsBefore = todoService.findAll();
        todoService.save("nick is working");
        List<TodoItem> items = todoService.findAll();
        List<TodoItem> itemsAfter = todoService.findAll();
        assertEquals(1,itemsAfter.size()-itemsBefore.size());
    }


    @Test
    void deleteItemTest(){
        List<TodoItem> itemsBefore = todoService.findAll();
        int key = todoService.save("Test data");
        List<TodoItem> itemsAfter = todoService.findAll();
        assertEquals(1,itemsAfter.stream().count()-itemsBefore.stream().count());
        assertTrue( todoService.delete(key));
     }

}
