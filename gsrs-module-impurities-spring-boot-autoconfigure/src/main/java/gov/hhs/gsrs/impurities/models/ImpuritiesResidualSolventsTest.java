package gov.hhs.gsrs.impurities.models;

import gsrs.GsrsEntityProcessorListener;
import gsrs.model.AbstractGsrsEntity;
import gsrs.model.AbstractGsrsManualDirtyEntity;
import ix.core.models.Indexable;
import ix.core.models.IxModel;
import ix.core.SingleParent;
import ix.core.models.ParentReference;
import ix.core.search.text.TextIndexerEntityListener;
import ix.ginas.models.serialization.GsrsDateDeserializer;
import ix.ginas.models.serialization.GsrsDateSerializer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@SingleParent
@Data
@Entity
@Table(name="SRSCID_IMPURITIES_RESIDU_TEST")
public class ImpuritiesResidualSolventsTest extends ImpuritiesCommanData {

    @Id
    @SequenceGenerator(name = "impResTestSeq", sequenceName = "SRSCID_SQ_IMPURITIES_R_TEST_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "impResTestSeq")
    @Column(name = "ID")
    public Long id;

    @Column(name = "SOURCE_TYPE")
    public String sourceType;

    @Column(name = "SOURCE")
    public String source;

    @Column(name = "SOURCE_ID")
    public String sourceId;

    @Column(name = "TEST")
    public String test;

    @Column(name = "TEST_TYPE")
    public String testType;

    @Column(name = "TEST_DESCRIPTION")
    public String testDescription;

    @Column(name = "COMMENTS")
    public String comments;

    /*
    @Version
    public Long internalVersion;

    @Column(name = "CREATED_BY")
    public String createdBy;

    @Column(name = "MODIFIED_BY")
    public String modifiedBy;

    @JsonSerialize(using = GsrsDateSerializer.class)
    @JsonDeserialize(using = GsrsDateDeserializer.class)
    @CreatedDate
    @Indexable( name = "Create Date", sortable=true)
    @Column(name = "CREATE_DATE")
    private Date creationDate;

    @JsonSerialize(using = GsrsDateSerializer.class)
    @JsonDeserialize(using = GsrsDateDeserializer.class)
    @LastModifiedDate
    @Indexable( name = "Last Modified Date", sortable=true)
    @Column(name = "MODIFY_DATE")
    private Date lastModifiedDate;
    */

    // Set PARENT Class, ImpuritiesSubstance
    @Indexable(indexed=false)
    @ParentReference
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="IMPURITIES_SUBSTANCE_ID")
    public ImpuritiesSubstance owner;

    // Set PARENT Class, ImpuritiesSubstance
    public void setOwner(ImpuritiesSubstance impuritiesSubstance) {
        this.owner = impuritiesSubstance;
    }

    // Set CHILDREN Class, ImpuritiesResidualSolvents
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner")
    public List<ImpuritiesResidualSolvents> impuritiesResidualSolventsList = new ArrayList<ImpuritiesResidualSolvents>();

    // Set CHILDREN Class, ImpuritiesResidualSolvents
    public void setImpuritiesResidualSolventsList(List<ImpuritiesResidualSolvents> impuritiesResidualSolventsList) {
        this.impuritiesResidualSolventsList = impuritiesResidualSolventsList;
        if(impuritiesResidualSolventsList !=null) {
            for (ImpuritiesResidualSolvents imp : impuritiesResidualSolventsList)
            {
                imp.setOwner(this);
            }
        }
    }
}
