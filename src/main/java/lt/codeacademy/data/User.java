package lt.codeacademy.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * @author Andrius Baltrunas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private ObjectId id;
   // @BsonProperty("vardas")
    private String name;
   // @BsonProperty("pavarde")
    private String surname;
   // @BsonProperty("alga")
    private double salary;
}