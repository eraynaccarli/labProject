LAB PROJECT
Dependency(Spring Security, Spring Boot, Thymeleaf, Bootstrap, Hibernate(JPA), MySQL Connector)


Entities
- Patient (her hastanın adı, soyadı, tc numarası, bulunuyor.)

- Laborant (her laborantın adı , soyadı , email ve şifresi(validation için) bulunmaktadır.)

- Report (her raporun başlığı, açıklaması,fotoğrafı ve tarihi vardır.

- Role (role-based çalışmak için)

Relations

Laborant
- Bir laborantın birden fazla raporu olabilir.(OneToMany) 

- Birden fazla laborantın birden fazla rolü olabilir.(ManyToMany)

Role
- Birden fazla rolün birden fazla sahibi olabilir.(ManyToMany)

Patient
- Bir hastanın birden fazla raporu olabilir.(OneToMany)

Report
- Birden fazla raporun bir laborantı olabilir.(ManyToOne)

- Birden fazla raporun bir hastası olabilir.(ManyToOne)

İçerik


Entity sınıflarımızı oluşturduk ve tablolarımızı mapledik.

JPA olarak Hibernate ,Veri tabanı olarak Mysql kullandık.

İlişki Entitylerimizi save etmek için Dto(Data Transfer Object) kullandık.

DAO'larımızın içinde view üzerinde yapacağımız search işlemimiz için QUERY'ler yazdık.

Service Interfaceleri tanımladık ve kullanacagımız methodları daha düzenli şekilde görmek amacıyla bu arayüze methodlarımızı tanımladık.

Ardından ServiceImplements sınıflarımızı oluşturduk ve service arayüzündeki methodlarımızın içlerini doldurduk.

Gelen istekleri karşılamak ve View ile köprü görevi görmesi için controller sınıflarımızı oluşturduk.

Security konfigurasyon işlemlerimiz için bir Security Config sınıfı oluşturduk WebSecurityConfigurerAdapter sınıfında bulunan methodları kullanmak için WebSecurityConfigurerAdapter sınıfını extends ettik.

Kullanıcılar bir işlem yapmadan önce login olmak zorundalar ve kayıt olmak için register sayfası oluşturduk ve kayıt olan kullanıcıya LABORANT rolünü verdik.

Authorize işlemi ile LABORANT rolüne sahip kullanıcıları yetkilendirdik ve yetki sahibi olmayanların uygulama üzerinde işlem yapmasının önüne geçmiş olduk.

Login olan kullanıcıları karşılaması ve gerekli işlemle yönlendirmesi için bir menü oluşturduk ve bu menüye aynı zamanda logout işlemi yapıp kullanıcıyı login penceresine yönelendirecek bir buton koyduk.

Laborant, hasta ve raporlar için kayıt ekranları oluşturduk yetkilendirilmiş kullanıcı bu ekranlardan gerekli işlemleri yapabilecektir.

Rapor girişi esnasında fotoğraf yüklenirken kayıt tamamlanmadan fotoğrafı ekranda görüntülenebilir hale getirdik böylece kullanıcı fotoğrafı uygun bulmaz ise kayıt olmadan değiştirme şansına sahip oldu.

Laborant,hasta ve raporların listelendiği sayfalarda gerekli bilgileri listeledik ve her sayfaya filtreleme işlemi için bir search box yerleştirdik ve aynı zamanda bilgilerde güncelleme işlemine yönlendirmesi amacıyla bir edit butonu koyduk böylece tüm kayıtları değiştirilebilir hale getirdik.

Kayıtlarda silme işlemleri için bütün sayfalara delete butonu ekledik.

![login](https://user-images.githubusercontent.com/69572868/192263393-d1056045-f008-4cd2-be56-bcaa0790aef4.png)
![labRegister](https://user-images.githubusercontent.com/69572868/192263424-8dbe2fa0-43b6-46d6-ad4e-a72283d12e5e.png)
![menu](https://user-images.githubusercontent.com/69572868/192263432-061e03c6-b1f4-47a9-853b-f66bc1c4ad3c.png)
![reports](https://user-images.githubusercontent.com/69572868/192263571-e12c9b62-2484-433a-9356-4ec880695a16.png)
![editReport](https://user-images.githubusercontent.com/69572868/192263598-142a2fde-3f63-455d-a086-d16010c08b6c.png)
![reportSearch](https://user-images.githubusercontent.com/69572868/192263621-df075213-7ebf-4d93-8fa7-74043c44dc78.png)
![reports](https://user-images.githubusercontent.com/69572868/192263647-e30a4a74-33bc-40e8-9880-c3a5dbbeb36b.png)


