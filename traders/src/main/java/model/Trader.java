package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.HibernateUtil;

@ManagedBean
@SessionScoped
@Entity
@Table(name = "Traders")
public class Trader {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Nickname")
	private String nickname;
	
	@Column(name = "Firstname")
	private String firstName;
	
	@Column(name = "Lastname")
	private String lastName;
	
	@Column(name = "DefunctDate")
	private LocalDate defunctDate;
	
	@Transient
	private LocalDate startDate;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="trader", cascade={CascadeType.ALL})
	private List<Stay> stays;
	
	public Trader() {
		;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDefunctDate() {
		return defunctDate;
	}

	public void setDefunctDate(LocalDate defunctDate) {
		this.defunctDate = defunctDate;
	}

	public int getId() {
		return id;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}

	@Override
	public String toString() {
		return "Trader [id=" + id + ", nickName=" + nickname + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", defunctDate=" + defunctDate + "]";
	}
	
	public void saveTrader() throws SQLException{
		SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
	}
	
}
