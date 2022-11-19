package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.pordefecto.resource;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.pordefecto.entity.PersonaDefault;
import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.pordefecto.repository.IDireccionRepositoryDefault;
import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.pordefecto.repository.IPersonaRepositoryDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidireccional/v1/one-to-many/default/personas")
public class PersonaResourceDefault {

    private final IPersonaRepositoryDefault personaRepositoryDefault;
    private final IDireccionRepositoryDefault direccionRepositoryDefault;

    public PersonaResourceDefault(IPersonaRepositoryDefault personaRepositoryDefault, IDireccionRepositoryDefault direccionRepositoryDefault) {
        this.personaRepositoryDefault = personaRepositoryDefault;
        this.direccionRepositoryDefault = direccionRepositoryDefault;
    }

    @GetMapping
    public ResponseEntity<?> listarPersonas() {
        return ResponseEntity.ok(this.personaRepositoryDefault.findAll());
    }

    /**
     * guardarPersonaConDirecciones(...), aquí mandaremos los datos de la PersonaDefault
     * que se guardarán en la BD. Además, dentro de ese mismo objeto vendrá un arreglo
     * conteniendo las direccionesDefault. Obviamente, como se va a CREAR estos registros
     * en la BD, el objeto JSON viene sin sus ids. El objeto enviado tendría esta forma:
     * {
     *     "nombre": "Anónimo",
     *     "apellido": "Sistemas",
     *     "createAt": "2022-11-18T20:05:00",
     *     "direccionesDefault": [
     *         {
     *             "avenida": "Trujillo",
     *             "manzana": "T",
     *             "lote": 10
     *         }
     *         {
     *             "avenida": "Arequipa",
     *             "manzana": "NC",
     *             "lote": 22
     *         }
     *     ]
     * }
     * ¿Por que se puede persistir el arreglo de DirecciónDefault, si estamos llamando al personaRepositorioDefault, que
     * es de PersonaDefault?
     * Es porque en PersonaDefault, que es nuestra clase principal, estamos definiendo en la relación @OneToMany el
     * cascade del tipo = CascadeType.ALL, esto significa que cada vez que se cree o guarde un PersonaDefault,
     * automáticamente creará a su dependiente, es decir a sus relacionados, en nuestro caso sería DirecciónDefault.
     * Podemos crear una PersonaDefault junto a su DireccionDefault y lo persistirá.
     */
    @PostMapping
    public ResponseEntity<?> guardarPersonaConDirecciones(@RequestBody PersonaDefault personaDefault) {
        return ResponseEntity.ok(this.personaRepositoryDefault.save(personaDefault));
    }
}
