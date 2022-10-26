import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/");
    List<File> paths = FileHelpers.getFiles(Paths.get("./technical"));
    int length = paths.size();
    assertEquals(String.format("There are %d total files to search.", length), h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?q=taxation");
    String expect = "Found 3 paths:\n./technical/biomed/1471-2296-3-3.txt\n./technical/government/Gen_Account_Office/d01591sp.txt\n./technical/plos/journal.pbio.0020052.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

