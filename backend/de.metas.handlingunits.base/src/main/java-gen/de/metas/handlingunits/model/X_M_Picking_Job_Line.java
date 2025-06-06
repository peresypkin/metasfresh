// Generated Model - DO NOT CHANGE
package de.metas.handlingunits.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import javax.annotation.Nullable;

/** Generated Model for M_Picking_Job_Line
 *  @author metasfresh (generated) 
 */
@SuppressWarnings("unused")
public class X_M_Picking_Job_Line extends org.compiere.model.PO implements I_M_Picking_Job_Line, org.compiere.model.I_Persistent 
{

	private static final long serialVersionUID = 1628110248L;

    /** Standard Constructor */
    public X_M_Picking_Job_Line (final Properties ctx, final int M_Picking_Job_Line_ID, @Nullable final String trxName)
    {
      super (ctx, M_Picking_Job_Line_ID, trxName);
    }

    /** Load Constructor */
    public X_M_Picking_Job_Line (final Properties ctx, final ResultSet rs, @Nullable final String trxName)
    {
      super (ctx, rs, trxName);
    }


	/** Load Meta Data */
	@Override
	protected org.compiere.model.POInfo initPO(final Properties ctx)
	{
		return org.compiere.model.POInfo.getPOInfo(Table_Name);
	}

	@Override
	public void setCatch_UOM_ID (final int Catch_UOM_ID)
	{
		if (Catch_UOM_ID < 1) 
			set_Value (COLUMNNAME_Catch_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_Catch_UOM_ID, Catch_UOM_ID);
	}

	@Override
	public int getCatch_UOM_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_Catch_UOM_ID);
	}

	@Override
	public void setC_BPartner_ID (final int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, C_BPartner_ID);
	}

	@Override
	public int getC_BPartner_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_BPartner_ID);
	}

	@Override
	public void setC_BPartner_Location_ID (final int C_BPartner_Location_ID)
	{
		if (C_BPartner_Location_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, C_BPartner_Location_ID);
	}

	@Override
	public int getC_BPartner_Location_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_BPartner_Location_ID);
	}

	@Override
	public org.compiere.model.I_C_Order getC_Order()
	{
		return get_ValueAsPO(COLUMNNAME_C_Order_ID, org.compiere.model.I_C_Order.class);
	}

	@Override
	public void setC_Order(final org.compiere.model.I_C_Order C_Order)
	{
		set_ValueFromPO(COLUMNNAME_C_Order_ID, org.compiere.model.I_C_Order.class, C_Order);
	}

	@Override
	public void setC_Order_ID (final int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_Value (COLUMNNAME_C_Order_ID, null);
		else 
			set_Value (COLUMNNAME_C_Order_ID, C_Order_ID);
	}

	@Override
	public int getC_Order_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_Order_ID);
	}

	@Override
	public org.compiere.model.I_C_OrderLine getC_OrderLine()
	{
		return get_ValueAsPO(COLUMNNAME_C_OrderLine_ID, org.compiere.model.I_C_OrderLine.class);
	}

	@Override
	public void setC_OrderLine(final org.compiere.model.I_C_OrderLine C_OrderLine)
	{
		set_ValueFromPO(COLUMNNAME_C_OrderLine_ID, org.compiere.model.I_C_OrderLine.class, C_OrderLine);
	}

	@Override
	public void setC_OrderLine_ID (final int C_OrderLine_ID)
	{
		if (C_OrderLine_ID < 1) 
			set_Value (COLUMNNAME_C_OrderLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_OrderLine_ID, C_OrderLine_ID);
	}

	@Override
	public int getC_OrderLine_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_OrderLine_ID);
	}

	@Override
	public void setC_UOM_ID (final int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, C_UOM_ID);
	}

	@Override
	public int getC_UOM_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_C_UOM_ID);
	}

	@Override
	public de.metas.handlingunits.model.I_M_HU getCurrent_PickTo_LU()
	{
		return get_ValueAsPO(COLUMNNAME_Current_PickTo_LU_ID, de.metas.handlingunits.model.I_M_HU.class);
	}

	@Override
	public void setCurrent_PickTo_LU(final de.metas.handlingunits.model.I_M_HU Current_PickTo_LU)
	{
		set_ValueFromPO(COLUMNNAME_Current_PickTo_LU_ID, de.metas.handlingunits.model.I_M_HU.class, Current_PickTo_LU);
	}

	@Override
	public void setCurrent_PickTo_LU_ID (final int Current_PickTo_LU_ID)
	{
		if (Current_PickTo_LU_ID < 1) 
			set_Value (COLUMNNAME_Current_PickTo_LU_ID, null);
		else 
			set_Value (COLUMNNAME_Current_PickTo_LU_ID, Current_PickTo_LU_ID);
	}

	@Override
	public int getCurrent_PickTo_LU_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_Current_PickTo_LU_ID);
	}

	@Override
	public de.metas.handlingunits.model.I_M_HU_PI getCurrent_PickTo_LU_PI()
	{
		return get_ValueAsPO(COLUMNNAME_Current_PickTo_LU_PI_ID, de.metas.handlingunits.model.I_M_HU_PI.class);
	}

	@Override
	public void setCurrent_PickTo_LU_PI(final de.metas.handlingunits.model.I_M_HU_PI Current_PickTo_LU_PI)
	{
		set_ValueFromPO(COLUMNNAME_Current_PickTo_LU_PI_ID, de.metas.handlingunits.model.I_M_HU_PI.class, Current_PickTo_LU_PI);
	}

	@Override
	public void setCurrent_PickTo_LU_PI_ID (final int Current_PickTo_LU_PI_ID)
	{
		if (Current_PickTo_LU_PI_ID < 1) 
			set_Value (COLUMNNAME_Current_PickTo_LU_PI_ID, null);
		else 
			set_Value (COLUMNNAME_Current_PickTo_LU_PI_ID, Current_PickTo_LU_PI_ID);
	}

	@Override
	public int getCurrent_PickTo_LU_PI_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_Current_PickTo_LU_PI_ID);
	}

	@Override
	public void setCurrent_PickTo_LU_QRCode (final @Nullable java.lang.String Current_PickTo_LU_QRCode)
	{
		set_Value (COLUMNNAME_Current_PickTo_LU_QRCode, Current_PickTo_LU_QRCode);
	}

	@Override
	public java.lang.String getCurrent_PickTo_LU_QRCode() 
	{
		return get_ValueAsString(COLUMNNAME_Current_PickTo_LU_QRCode);
	}

	@Override
	public de.metas.handlingunits.model.I_M_HU_PI getCurrent_PickTo_TU_PI()
	{
		return get_ValueAsPO(COLUMNNAME_Current_PickTo_TU_PI_ID, de.metas.handlingunits.model.I_M_HU_PI.class);
	}

	@Override
	public void setCurrent_PickTo_TU_PI(final de.metas.handlingunits.model.I_M_HU_PI Current_PickTo_TU_PI)
	{
		set_ValueFromPO(COLUMNNAME_Current_PickTo_TU_PI_ID, de.metas.handlingunits.model.I_M_HU_PI.class, Current_PickTo_TU_PI);
	}

	@Override
	public void setCurrent_PickTo_TU_PI_ID (final int Current_PickTo_TU_PI_ID)
	{
		if (Current_PickTo_TU_PI_ID < 1) 
			set_Value (COLUMNNAME_Current_PickTo_TU_PI_ID, null);
		else 
			set_Value (COLUMNNAME_Current_PickTo_TU_PI_ID, Current_PickTo_TU_PI_ID);
	}

	@Override
	public int getCurrent_PickTo_TU_PI_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_Current_PickTo_TU_PI_ID);
	}

	@Override
	public void setIsManuallyClosed (final boolean IsManuallyClosed)
	{
		set_Value (COLUMNNAME_IsManuallyClosed, IsManuallyClosed);
	}

	@Override
	public boolean isManuallyClosed() 
	{
		return get_ValueAsBoolean(COLUMNNAME_IsManuallyClosed);
	}

	@Override
	public void setM_HU_PI_Item_Product_ID (final int M_HU_PI_Item_Product_ID)
	{
		if (M_HU_PI_Item_Product_ID < 1) 
			set_Value (COLUMNNAME_M_HU_PI_Item_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_HU_PI_Item_Product_ID, M_HU_PI_Item_Product_ID);
	}

	@Override
	public int getM_HU_PI_Item_Product_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_M_HU_PI_Item_Product_ID);
	}

	@Override
	public de.metas.handlingunits.model.I_M_Picking_Job getM_Picking_Job()
	{
		return get_ValueAsPO(COLUMNNAME_M_Picking_Job_ID, de.metas.handlingunits.model.I_M_Picking_Job.class);
	}

	@Override
	public void setM_Picking_Job(final de.metas.handlingunits.model.I_M_Picking_Job M_Picking_Job)
	{
		set_ValueFromPO(COLUMNNAME_M_Picking_Job_ID, de.metas.handlingunits.model.I_M_Picking_Job.class, M_Picking_Job);
	}

	@Override
	public void setM_Picking_Job_ID (final int M_Picking_Job_ID)
	{
		if (M_Picking_Job_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Picking_Job_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Picking_Job_ID, M_Picking_Job_ID);
	}

	@Override
	public int getM_Picking_Job_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_M_Picking_Job_ID);
	}

	@Override
	public void setM_Picking_Job_Line_ID (final int M_Picking_Job_Line_ID)
	{
		if (M_Picking_Job_Line_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Picking_Job_Line_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Picking_Job_Line_ID, M_Picking_Job_Line_ID);
	}

	@Override
	public int getM_Picking_Job_Line_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_M_Picking_Job_Line_ID);
	}

	@Override
	public void setM_PickingSlot_ID (final int M_PickingSlot_ID)
	{
		if (M_PickingSlot_ID < 1) 
			set_Value (COLUMNNAME_M_PickingSlot_ID, null);
		else 
			set_Value (COLUMNNAME_M_PickingSlot_ID, M_PickingSlot_ID);
	}

	@Override
	public int getM_PickingSlot_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_M_PickingSlot_ID);
	}

	@Override
	public void setM_Product_ID (final int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Product_ID, M_Product_ID);
	}

	@Override
	public int getM_Product_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_M_Product_ID);
	}

	@Override
	public void setM_ShipmentSchedule_ID (final int M_ShipmentSchedule_ID)
	{
		if (M_ShipmentSchedule_ID < 1) 
			set_Value (COLUMNNAME_M_ShipmentSchedule_ID, null);
		else 
			set_Value (COLUMNNAME_M_ShipmentSchedule_ID, M_ShipmentSchedule_ID);
	}

	@Override
	public int getM_ShipmentSchedule_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_M_ShipmentSchedule_ID);
	}

	@Override
	public org.eevolution.model.I_PP_Order getPP_Order()
	{
		return get_ValueAsPO(COLUMNNAME_PP_Order_ID, org.eevolution.model.I_PP_Order.class);
	}

	@Override
	public void setPP_Order(final org.eevolution.model.I_PP_Order PP_Order)
	{
		set_ValueFromPO(COLUMNNAME_PP_Order_ID, org.eevolution.model.I_PP_Order.class, PP_Order);
	}

	@Override
	public void setPP_Order_ID (final int PP_Order_ID)
	{
		if (PP_Order_ID < 1) 
			set_Value (COLUMNNAME_PP_Order_ID, null);
		else 
			set_Value (COLUMNNAME_PP_Order_ID, PP_Order_ID);
	}

	@Override
	public int getPP_Order_ID() 
	{
		return get_ValueAsInt(COLUMNNAME_PP_Order_ID);
	}

	@Override
	public void setProcessed (final boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Processed);
	}

	@Override
	public boolean isProcessed() 
	{
		return get_ValueAsBoolean(COLUMNNAME_Processed);
	}

	@Override
	public void setQtyToPick (final BigDecimal QtyToPick)
	{
		set_Value (COLUMNNAME_QtyToPick, QtyToPick);
	}

	@Override
	public BigDecimal getQtyToPick() 
	{
		final BigDecimal bd = get_ValueAsBigDecimal(COLUMNNAME_QtyToPick);
		return bd != null ? bd : BigDecimal.ZERO;
	}
}