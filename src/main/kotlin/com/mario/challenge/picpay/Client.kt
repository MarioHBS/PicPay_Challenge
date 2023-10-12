import jakarta.persistence.*

@Entity(name = "users")
@Table(name = "users")
class Client(
        var amount: Long,
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private var id: String) {
}