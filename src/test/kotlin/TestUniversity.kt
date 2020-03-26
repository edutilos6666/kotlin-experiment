import org.aghayevn.dao.UniversityDAO
import org.aghayevn.dao.UniversityDAOInMemoryImpl
import org.aghayevn.model.Address
import org.aghayevn.model.University
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.api.Assertions.*
/**
 * created by  Nijat Aghayev on 26.03.20
 */
class TestUniversity {
    private lateinit var dao: UniversityDAO

    @BeforeEach
    fun setUp() {
        dao = UniversityDAOInMemoryImpl()
    }

    @AfterEach
    fun clearUp() {
        dao.truncate()
    }

    @Test
    fun `test create universities`() {
        val uniRUB: University = University(
            name = "RUB",
            address = Address(country = "Germany", city = "Bochum", zip = "44801", street = "Universitätstraße"),
            ranking = 7.0
            )

        val uniEssenDuisburg: University = University(
            name = "Uni Essen-Duisburg",
            address = Address(country = "Germany", city = "Essen", zip = "45414", street = "Gladbeckerstraße"),
            ranking = 5.6
        )

        dao.insert(uniRUB)
        dao.insert(uniEssenDuisburg)
        val uniList: MutableList<University> = dao.findAll()
        var one: University? = dao.findById(uniList[0].id)

        // single test
        Assertions.assertEquals(2, uniList.size)

        // test batch
        Assertions.assertAll(
            Executable {
                Assertions.assertEquals(2, uniList.size)
                val filtered = uniList.filter { it.name == "RUB" }
                Assertions.assertEquals(1, filtered.size)
                Assertions.assertEquals(1, uniList.filter { it.name == "RUB" }.size)
            },
            Executable {
                Assertions.assertNotNull(one)
                Assertions.assertEquals("RUB", one?.name)
                Assertions.assertEquals("Germany", one?.address?.country)
                Assertions.assertEquals("Bochum", one?.address?.city)
                Assertions.assertEquals("44801", one?.address?.zip)
                Assertions.assertEquals("Universitätstraße", one?.address?.street)
                Assertions.assertEquals(7.0, one?.ranking!!, 0.01)
            }
        )
    }


    @Test
    fun `test update University`() {
        val uniRUB: University = University(
            name = "RUB",
            address = Address(country = "Germany", city = "Bochum", zip = "44801", street = "Universitätstraße"),
            ranking = 7.0
        )

        val uniEssenDuisburg: University = University(
            name = "Uni Essen-Duisburg",
            address = Address(country = "Germany", city = "Essen", zip = "45414", street = "Gladbeckerstraße"),
            ranking = 5.6
        )

        dao.insertAll(uniRUB, uniEssenDuisburg)

        var all = dao.findAll()

        assertEquals(2, all.size)

        var one = dao.findById(all[0].id)

        assertNotNull(one)

        one?.name = "NEW RUB"
        one?.address= Address(country= "USA", city = "Los Angeles", zip = "90001", street = "Broadway")

        dao.update(one!!)

        one = dao.findById(one.id)

        assertAll(
            Executable {
                assertNotNull(one)
                assertEquals("NEW RUB", one?.name)
                assertEquals("USA", one?.address?.country)
                assertEquals("Los Angeles", one?.address?.city)
                assertEquals("90001", one?.address?.zip)
                assertEquals("Broadway", one?.address?.street)
            }
        )

    }
}