export class UserModel {
    public id: string;
    public firstName: string;
    public lastName: string;
    public username: string;
    public email: string;
    public phone: string;
    public nic: string;
    public address: string;
    public password: string;
    public roleId: string;
  
    public constructor(
        firstName: string,
        lastName: string,
        username: string,
        email: string,
        phone: string,
        nic: string,
        address: string,
        password: string,
        roleId: string
    ) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = username;
      this.email = email;
      this.phone = phone;
      this.nic = nic;
      this.address = address;
      this.password = password;
      this.roleId = roleId;
    }
  
  }
  