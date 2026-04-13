package backend2026.musiikkikokoelma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import backend2026.musiikkikokoelma.web.MusiikkikokoelmaController;
import backend2026.musiikkikokoelma.web.MusiikkikokoelmaRestController;

@SpringBootTest
class MusiikkikokoelmaApplicationTests {

	@Autowired
	private MusiikkikokoelmaController musiikkikokoelmaController;

	@Autowired
	private MusiikkikokoelmaRestController musiikkikokoelmaRestController;

	@Test
	void contextLoads() {
	}

	@Test
	public void musiikkikokoelmaControllerLoad() throws Exception {
		assertThat(musiikkikokoelmaController).isNotNull();
	}

	@Test
	public void musiikkikokoelmaRestControllerLoad() throws Exception {
		assertThat(musiikkikokoelmaRestController).isNotNull();
	}

}
