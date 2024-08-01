package ru.ivanchin.centralbank.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;
import ru.ivanchin.centralbank.workWithXml.adapter.LocalDateAdapter;
import ru.ivanchin.centralbank.workWithXml.adapter.LocalDateTimeAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "central_bank_entity")
@XmlRootElement(name = "ED807")
@XmlAccessorType(XmlAccessType.FIELD)
public class CentralBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlAttribute(name = "xmlns")
    private String xmlns;

    @XmlAttribute(name = "EDNo")
    private Long EDNo;

    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "EDDate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate EDDate;

    @XmlAttribute(name = "EDAuthor")
    private Long EDAuthor;

    @XmlAttribute(name = "CreationReason")
    private String CreationReason;

    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(name = "CreationDateTime")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime CreationDateTime;

    @XmlAttribute(name = "InfoTypeCode")
    private String InfoTypeCode;

    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "BusinessDay")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate BusinessDay;

    @XmlAttribute(name = "DirectoryVersion")
    private Integer DirectoryVersion;

    @OneToMany
    @JoinColumn(name = "BIC_directory_entry_entity_id")
    @XmlElement(name = "BICDirectoryEntry")
    private Set<BICDirectoryEntry> listBICDirectoryEntries;


    public void addBank(BICDirectoryEntry BICDirectoryEntry) {
        if (listBICDirectoryEntries == null)
            listBICDirectoryEntries = new HashSet<>() {{ add(BICDirectoryEntry); }};
        else
            listBICDirectoryEntries.add(BICDirectoryEntry);
    }

}
