CREATE DEFINER=`newuser`@`%` PROCEDURE `vaspitac_prijava`(in ime varchar(45), in sifra varchar(45), out rezultat boolean)
BEGIN

	select true into rezultat;
	if not exists(select * from vaspitac where KorisnickoIme=ime and Lozinka=sifra) then
		select false into rezultat;
	end if;
    
    
END