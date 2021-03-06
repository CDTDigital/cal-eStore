package com.hpe.calEStore.dao.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OrderStatus generated by hbm2java
 */
@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatus implements java.io.Serializable {

	private OrderStatusId id;
	private PurchaseOrder purchaseOrder;
	private Status status;

	public OrderStatus() {
		// Do nothing... Hibernate needs this mandatory
	}

	public OrderStatus(OrderStatusId id, PurchaseOrder purchaseOrder,
			Status status) {
		this.id = id;
		this.purchaseOrder = purchaseOrder;
		this.status = status;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "orderId", column = @Column(name = "ORDER_ID", nullable = false)),
			@AttributeOverride(name = "statusId", column = @Column(name = "STATUS_ID", nullable = false)),
			@AttributeOverride(name = "lastModifiedTm", column = @Column(name = "LAST_MODIFIED_TM", nullable = false, length = 19)) })
	public OrderStatusId getId() {
		return this.id;
	}

	public void setId(OrderStatusId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false, insertable = false, updatable = false)
	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", nullable = false, insertable = false, updatable = false)
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
