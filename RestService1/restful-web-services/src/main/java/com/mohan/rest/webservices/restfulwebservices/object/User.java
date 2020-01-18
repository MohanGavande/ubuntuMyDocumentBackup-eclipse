package com.mohan.rest.webservices.restfulwebservices.object;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
		
		@Size(min = 2)
		private String name;
		
		@Past
		private Date birthDate= new Date();
		
		protected User() {
			
		}
		public User(int i, String string, Date date) {
			super();
			this.id = i;
			this.name = string;
			this.birthDate = date;
		}
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the birthDate
		 */
		public Date getBirthDate() {
			return birthDate;
		}
		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
		

}
