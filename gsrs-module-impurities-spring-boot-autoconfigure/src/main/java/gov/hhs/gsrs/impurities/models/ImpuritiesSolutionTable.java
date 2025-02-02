package gov.hhs.gsrs.impurities.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "SRSCID_IMPURITIES_SOLUTION_TABLE")
public class ImpuritiesSolutionTable extends ImpuritiesCommonData {

    @Id
    @SequenceGenerator(name = "impSolTableSeq", sequenceName = "SRSCID_SQ_IMPURITIES_SOL_TABLE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "impSolTableSeq")
    @Column(name = "ID")
    public Long id;

    @Column(name = "SOLUTION_TIME")
    public String solutionTime;

    @Column(name = "SOLUTION_A_PERCENT")
    public String solutionAPercent;

    @Column(name = "SOLUTION_B_PERCENT")
    public String solutionBPercent;

    @Column(name = "SOLUTION_C_PERCENT")
    public String solutionCPercent;

    @Column(name = "SOLUTION_D_PERCENT")
    public String solutionDPercent;

    @Column(name = "SOLUTION_E_PERCENT")
    public String solutionEPercent;

    @Column(name = "SOLUTION_F_PERCENT")
    public String solutionFPercent;

    @Column(name = "SOLUTION_G_PERCENT")
    public String solutionGPercent;

    @Column(name = "SOLUTION_H_PERCENT")
    public String solutionHPercent;

    @Column(name = "SOLUTION_I_PERCENT")
    public String solutionIPercent;

    @Column(name = "SOLUTION_J_PERCENT")
    public String solutionJPercent;

    // Set PARENT Class, ImpuritiesTesting
    @Indexable(indexed = false)
    @ParentReference
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "IMPURITIES_TEST_ID")
    public ImpuritiesTesting owner;

    // Set PARENT Class, ImpuritiesTesting
    public void setOwner(ImpuritiesTesting impuritiesTesting) {
        this.owner = impuritiesTesting;
    }

}
