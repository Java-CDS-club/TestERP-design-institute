package ru.oskin_di.TestERPdesigninstitute.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "work_tasks")
@NamedEntityGraph(
        name = "work_tasks.for-front",
        attributeNodes = {
                @NamedAttributeNode(value = "employeeCreator", subgraph = "employee"),
                @NamedAttributeNode(value = "employeeExecutor", subgraph = "employee")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "employee",
                        attributeNodes = {
                                @NamedAttributeNode("id"),
                                @NamedAttributeNode("name")
                        }
                )
        }
)
public class WorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "in_progress")
    private boolean inProgress;

    @ManyToOne
    @JoinColumn(name = "id_creator")
    private Employee employeeCreator;

    @ManyToOne
    @JoinColumn(name = "id_executor")
    private Employee employeeExecutor;


}
