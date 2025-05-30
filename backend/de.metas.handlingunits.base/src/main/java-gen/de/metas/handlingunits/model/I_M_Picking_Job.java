package de.metas.handlingunits.model;

import javax.annotation.Nullable;
import org.adempiere.model.ModelColumn;

/** Generated Interface for M_Picking_Job
 *  @author metasfresh (generated) 
 */
@SuppressWarnings("unused")
public interface I_M_Picking_Job 
{

	String Table_Name = "M_Picking_Job";

//	/** AD_Table_ID=541906 */
//	int Table_ID = org.compiere.model.MTable.getTable_ID(Table_Name);


	/**
	 * Get Client.
	 * Client/Tenant for this installation.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getAD_Client_ID();

	String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/**
	 * Set Organisation.
	 * Organisational entity within client
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setAD_Org_ID (int AD_Org_ID);

	/**
	 * Get Organisation.
	 * Organisational entity within client
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getAD_Org_ID();

	String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/**
	 * Set Business Partner.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setC_BPartner_ID (int C_BPartner_ID);

	/**
	 * Get Business Partner.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getC_BPartner_ID();

	String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/**
	 * Set Location.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setC_BPartner_Location_ID (int C_BPartner_Location_ID);

	/**
	 * Get Location.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getC_BPartner_Location_ID();

	String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";

	/**
	 * Set Sales order.
	 * Order
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setC_Order_ID (int C_Order_ID);

	/**
	 * Get Sales order.
	 * Order
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getC_Order_ID();

	@Nullable org.compiere.model.I_C_Order getC_Order();

	void setC_Order(@Nullable org.compiere.model.I_C_Order C_Order);

	ModelColumn<I_M_Picking_Job, org.compiere.model.I_C_Order> COLUMN_C_Order_ID = new ModelColumn<>(I_M_Picking_Job.class, "C_Order_ID", org.compiere.model.I_C_Order.class);
	String COLUMNNAME_C_Order_ID = "C_Order_ID";

	/**
	 * Get Created.
	 * Date this record was created
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getCreated();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_Created = new ModelColumn<>(I_M_Picking_Job.class, "Created", null);
	String COLUMNNAME_Created = "Created";

	/**
	 * Get Created By.
	 * User who created this records
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getCreatedBy();

	String COLUMNNAME_CreatedBy = "CreatedBy";

	/**
	 * Set Shipmentdate.
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setDeliveryDate (@Nullable java.sql.Timestamp DeliveryDate);

	/**
	 * Get Shipmentdate.
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.sql.Timestamp getDeliveryDate();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_DeliveryDate = new ModelColumn<>(I_M_Picking_Job.class, "DeliveryDate", null);
	String COLUMNNAME_DeliveryDate = "DeliveryDate";

	/**
	 * Set Diff. Shipment Address.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setDeliveryToAddress (@Nullable java.lang.String DeliveryToAddress);

	/**
	 * Get Diff. Shipment Address.
	 *
	 * <br>Type: String
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getDeliveryToAddress();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_DeliveryToAddress = new ModelColumn<>(I_M_Picking_Job.class, "DeliveryToAddress", null);
	String COLUMNNAME_DeliveryToAddress = "DeliveryToAddress";

	/**
	 * Set Status.
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setDocStatus (java.lang.String DocStatus);

	/**
	 * Get Status.
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.lang.String getDocStatus();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_DocStatus = new ModelColumn<>(I_M_Picking_Job.class, "DocStatus", null);
	String COLUMNNAME_DocStatus = "DocStatus";

	/**
	 * Set Unloading Address.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setHandOver_Location_ID (int HandOver_Location_ID);

	/**
	 * Get Unloading Address.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getHandOver_Location_ID();

	String COLUMNNAME_HandOver_Location_ID = "HandOver_Location_ID";

	/**
	 * Set Handover partner.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setHandOver_Partner_ID (int HandOver_Partner_ID);

	/**
	 * Get Handover partner.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getHandOver_Partner_ID();

	String COLUMNNAME_HandOver_Partner_ID = "HandOver_Partner_ID";

	/**
	 * Set Active.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsActive (boolean IsActive);

	/**
	 * Get Active.
	 * The record is active in the system
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isActive();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_IsActive = new ModelColumn<>(I_M_Picking_Job.class, "IsActive", null);
	String COLUMNNAME_IsActive = "IsActive";

	/**
	 * Set Allow picking any HU.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsAllowPickingAnyHU (boolean IsAllowPickingAnyHU);

	/**
	 * Get Allow picking any HU.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isAllowPickingAnyHU();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_IsAllowPickingAnyHU = new ModelColumn<>(I_M_Picking_Job.class, "IsAllowPickingAnyHU", null);
	String COLUMNNAME_IsAllowPickingAnyHU = "IsAllowPickingAnyHU";

	/**
	 * Set Approved.
	 * Indicates if this document requires approval
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsApproved (boolean IsApproved);

	/**
	 * Get Approved.
	 * Indicates if this document requires approval
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isApproved();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_IsApproved = new ModelColumn<>(I_M_Picking_Job.class, "IsApproved", null);
	String COLUMNNAME_IsApproved = "IsApproved";

	/**
	 * Set Picking Review Required.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsPickingReviewRequired (boolean IsPickingReviewRequired);

	/**
	 * Get Picking Review Required.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isPickingReviewRequired();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_IsPickingReviewRequired = new ModelColumn<>(I_M_Picking_Job.class, "IsPickingReviewRequired", null);
	String COLUMNNAME_IsPickingReviewRequired = "IsPickingReviewRequired";

	/**
	 * Set Ready To Review.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setIsReadyToReview (boolean IsReadyToReview);

	/**
	 * Get Ready To Review.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isReadyToReview();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_IsReadyToReview = new ModelColumn<>(I_M_Picking_Job.class, "IsReadyToReview", null);
	String COLUMNNAME_IsReadyToReview = "IsReadyToReview";

	/**
	 * Set LU.
	 * Loading Unit
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_LU_HU_ID (int M_LU_HU_ID);

	/**
	 * Get LU.
	 * Loading Unit
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_LU_HU_ID();

	@Nullable de.metas.handlingunits.model.I_M_HU getM_LU_HU();

	void setM_LU_HU(@Nullable de.metas.handlingunits.model.I_M_HU M_LU_HU);

	ModelColumn<I_M_Picking_Job, de.metas.handlingunits.model.I_M_HU> COLUMN_M_LU_HU_ID = new ModelColumn<>(I_M_Picking_Job.class, "M_LU_HU_ID", de.metas.handlingunits.model.I_M_HU.class);
	String COLUMNNAME_M_LU_HU_ID = "M_LU_HU_ID";

	/**
	 * Set Packvorschrift (LU).
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_LU_HU_PI_ID (int M_LU_HU_PI_ID);

	/**
	 * Get Packvorschrift (LU).
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_LU_HU_PI_ID();

	@Nullable de.metas.handlingunits.model.I_M_HU_PI getM_LU_HU_PI();

	void setM_LU_HU_PI(@Nullable de.metas.handlingunits.model.I_M_HU_PI M_LU_HU_PI);

	ModelColumn<I_M_Picking_Job, de.metas.handlingunits.model.I_M_HU_PI> COLUMN_M_LU_HU_PI_ID = new ModelColumn<>(I_M_Picking_Job.class, "M_LU_HU_PI_ID", de.metas.handlingunits.model.I_M_HU_PI.class);
	String COLUMNNAME_M_LU_HU_PI_ID = "M_LU_HU_PI_ID";

	/**
	 * Set Picking Job.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setM_Picking_Job_ID (int M_Picking_Job_ID);

	/**
	 * Get Picking Job.
	 *
	 * <br>Type: ID
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getM_Picking_Job_ID();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_M_Picking_Job_ID = new ModelColumn<>(I_M_Picking_Job.class, "M_Picking_Job_ID", null);
	String COLUMNNAME_M_Picking_Job_ID = "M_Picking_Job_ID";

	/**
	 * Set Picking Slot.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_PickingSlot_ID (int M_PickingSlot_ID);

	/**
	 * Get Picking Slot.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_PickingSlot_ID();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_M_PickingSlot_ID = new ModelColumn<>(I_M_Picking_Job.class, "M_PickingSlot_ID", null);
	String COLUMNNAME_M_PickingSlot_ID = "M_PickingSlot_ID";

	/**
	 * Set Packing Instruction (TU).
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setM_TU_HU_PI_ID (int M_TU_HU_PI_ID);

	/**
	 * Get Packing Instruction (TU).
	 *
	 * <br>Type: Table
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getM_TU_HU_PI_ID();

	@Nullable de.metas.handlingunits.model.I_M_HU_PI getM_TU_HU_PI();

	void setM_TU_HU_PI(@Nullable de.metas.handlingunits.model.I_M_HU_PI M_TU_HU_PI);

	ModelColumn<I_M_Picking_Job, de.metas.handlingunits.model.I_M_HU_PI> COLUMN_M_TU_HU_PI_ID = new ModelColumn<>(I_M_Picking_Job.class, "M_TU_HU_PI_ID", de.metas.handlingunits.model.I_M_HU_PI.class);
	String COLUMNNAME_M_TU_HU_PI_ID = "M_TU_HU_PI_ID";

	/**
	 * Set Pick From HU.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setPickFrom_HU_ID (int PickFrom_HU_ID);

	/**
	 * Get Pick From HU.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getPickFrom_HU_ID();

	@Nullable de.metas.handlingunits.model.I_M_HU getPickFrom_HU();

	void setPickFrom_HU(@Nullable de.metas.handlingunits.model.I_M_HU PickFrom_HU);

	ModelColumn<I_M_Picking_Job, de.metas.handlingunits.model.I_M_HU> COLUMN_PickFrom_HU_ID = new ModelColumn<>(I_M_Picking_Job.class, "PickFrom_HU_ID", de.metas.handlingunits.model.I_M_HU.class);
	String COLUMNNAME_PickFrom_HU_ID = "PickFrom_HU_ID";

	/**
	 * Set Pick From HU QR Code.
	 *
	 * <br>Type: TextLong
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setPickFrom_HUQRCode (@Nullable java.lang.String PickFrom_HUQRCode);

	/**
	 * Get Pick From HU QR Code.
	 *
	 * <br>Type: TextLong
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.lang.String getPickFrom_HUQRCode();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_PickFrom_HUQRCode = new ModelColumn<>(I_M_Picking_Job.class, "PickFrom_HUQRCode", null);
	String COLUMNNAME_PickFrom_HUQRCode = "PickFrom_HUQRCode";

	/**
	 * Set Aggregation Type.
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setPickingJobAggregationType (java.lang.String PickingJobAggregationType);

	/**
	 * Get Aggregation Type.
	 *
	 * <br>Type: List
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.lang.String getPickingJobAggregationType();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_PickingJobAggregationType = new ModelColumn<>(I_M_Picking_Job.class, "PickingJobAggregationType", null);
	String COLUMNNAME_PickingJobAggregationType = "PickingJobAggregationType";

	/**
	 * Set Picking User.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setPicking_User_ID (int Picking_User_ID);

	/**
	 * Get Picking User.
	 *
	 * <br>Type: Search
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	int getPicking_User_ID();

	String COLUMNNAME_Picking_User_ID = "Picking_User_ID";

	/**
	 * Set Date ready.
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	void setPreparationDate (@Nullable java.sql.Timestamp PreparationDate);

	/**
	 * Get Date ready.
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: false
	 * <br>Virtual Column: false
	 */
	@Nullable java.sql.Timestamp getPreparationDate();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_PreparationDate = new ModelColumn<>(I_M_Picking_Job.class, "PreparationDate", null);
	String COLUMNNAME_PreparationDate = "PreparationDate";

	/**
	 * Set Processed.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	void setProcessed (boolean Processed);

	/**
	 * Get Processed.
	 *
	 * <br>Type: YesNo
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	boolean isProcessed();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_Processed = new ModelColumn<>(I_M_Picking_Job.class, "Processed", null);
	String COLUMNNAME_Processed = "Processed";

	/**
	 * Get Updated.
	 * Date this record was updated
	 *
	 * <br>Type: DateTime
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	java.sql.Timestamp getUpdated();

	ModelColumn<I_M_Picking_Job, Object> COLUMN_Updated = new ModelColumn<>(I_M_Picking_Job.class, "Updated", null);
	String COLUMNNAME_Updated = "Updated";

	/**
	 * Get Updated By.
	 * User who updated this records
	 *
	 * <br>Type: Search
	 * <br>Mandatory: true
	 * <br>Virtual Column: false
	 */
	int getUpdatedBy();

	String COLUMNNAME_UpdatedBy = "UpdatedBy";
}
