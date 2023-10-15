package com.openclassrooms.poseidonInc.nnk.domain;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
@Table(name = "bidlist")
public class BidList {
	@Id
	@Column(name = "bidlistid")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer BidListId;
	@NotBlank(message = "Account is mandatory")
	private String account;
	@NotBlank(message = "type is mandatory")
	private String type;
	@Column(name="bidquantity")
	private Double bidQuantity;
	@Column(name="askquantity")
	private Double askQuantity;
	private Double bid;
	private Double ask;
	private String benchmark;
	@Column(name="bidlistdate")
	private Timestamp bidListDate;
	private String commentary;
	private String security;
	private String status;
	private String trader;
	private String book;
	@Column(name="creationname")
	private String creationName;
	@Column(name="creationdate")
	private Timestamp creationDate;
	@Column(name="revisionname")
	private String revisionName;
	@Column(name="revisiondate")
	private Timestamp revisionDate;
	@Column(name="dealname")
	private String dealName;
	@Column(name="dealtype")
	private String dealType;
	@Column(name="sourcelistid")
	private String sourceListId;
	private String side;

	/**
	 * @return the BidListId
	 */
	public Integer getBidListId() {
		return this.BidListId;
	}
	
	/**
	 * @param id the BidListId to set
	 */
	public void setBidListId(Integer id) {
		this.BidListId = id;
	}
	
	/**
	 * @return the account
	 */
	public  String getAccount() {
		return account;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/**
	 * @return the account
	 */
	public  String getType() {
		return type;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the bidQuantity
	 */
	public Double getBidQuantity() {
		return bidQuantity;
	}

	/**
	 * @param bidQuantity the bidQuantity to set
	 */
	public void setBidQuantity(Double bidQuantity) {
		this.bidQuantity = bidQuantity;
	}

	/**
	 * @return the askQuantity
	 */
	public Double getAskQuantity() {
		return askQuantity;
	}

	/**
	 * @param askQuantity the askQuantity to set
	 */
	public void setAskQuantity(Double askQuantity) {
		this.askQuantity = askQuantity;
	}

	/**
	 * @return the bid
	 */
	public Double getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(Double bid) {
		this.bid = bid;
	}

	/**
	 * @return the ask
	 */
	public Double getAsk() {
		return ask;
	}

	/**
	 * @param ask the ask to set
	 */
	public void setAsk(Double ask) {
		this.ask = ask;
	}

	/**
	 * @return the benchmark
	 */
	public String getBenchmark() {
		return benchmark;
	}

	/**
	 * @param benchmark the benchmark to set
	 */
	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	/**
	 * @return the bidListDate
	 */
	public Timestamp getBidListDate() {
		return bidListDate;
	}

	/**
	 * @param bidListDate the bidListDate to set
	 */
	public void setBidListDate(Timestamp bidListDate) {
		this.bidListDate = bidListDate;
	}

	/**
	 * @return the commentary
	 */
	public String getCommentary() {
		return commentary;
	}

	/**
	 * @param commentary the commentary to set
	 */
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	/**
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}

	/**
	 * @param security the security to set
	 */
	public void setSecurity(String security) {
		this.security = security;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the trader
	 */
	public String getTrader() {
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public void setTrader(String trader) {
		this.trader = trader;
	}

	/**
	 * @return the book
	 */
	public String getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(String book) {
		this.book = book;
	}

	/**
	 * @return the creationName
	 */
	public String getCreationName() {
		return creationName;
	}

	/**
	 * @param creationName the creationName to set
	 */
	public void setCreationName(String creationName) {
		this.creationName = creationName;
	}

	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the revisionName
	 */
	public String getRevisionName() {
		return revisionName;
	}

	/**
	 * @param revisionName the revisionName to set
	 */
	public void setRevisionName(String revisionName) {
		this.revisionName = revisionName;
	}

	/**
	 * @return the revisionDate
	 */
	public Timestamp getRevisionDate() {
		return revisionDate;
	}

	/**
	 * @param revisionDate the revisionDate to set
	 */
	public void setRevisionDate(Timestamp revisionDate) {
		this.revisionDate = revisionDate;
	}

	/**
	 * @return the dealName
	 */
	public String getDealName() {
		return dealName;
	}

	/**
	 * @param dealName the dealName to set
	 */
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}

	/**
	 * @return the dealType
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * @param dealType the dealType to set
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	/**
	 * @return the sourceListId
	 */
	public String getSourceListId() {
		return sourceListId;
	}

	/**
	 * @param sourceListId the sourceListId to set
	 */
	public void setSourceListId(String sourceListId) {
		this.sourceListId = sourceListId;
	}

	/**
	 * @return the side
	 */
	public String getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(String side) {
		this.side = side;
	}
}
