package hrms.hrms.business.abstracts;



public interface UserValidatorService<T> {

	boolean isValid(T user);

}
