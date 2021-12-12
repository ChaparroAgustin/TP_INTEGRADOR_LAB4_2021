package Negocio;

import java.time.LocalDateTime;

public class ValidacionesNegocio {

	public boolean validarFecha(int Anio, int Mes, int Dia)
	{
		boolean fechaCorrecta = false;
		int AnioActual = LocalDateTime.now().getYear();
		//int MesActual = LocalDateTime.now().getMonthValue();
		//int DiaActual = LocalDateTime.now().getDayOfMonth();
		
		if(Anio+17 > AnioActual || Mes < 1 || Mes > 12 || Dia < 1 || Dia > 31)
		{
			fechaCorrecta = false;
		}
		else
		{
			if((Anio % 4 == 0) && ((Anio % 100 != 0) || (Anio % 400 == 0)))
			{
				if(Mes == 2)
				{
					if(Dia > 29)
					{
						fechaCorrecta = false;
					}
					else
					{
						fechaCorrecta = true;
					}
				}
				else
				{
					if(Mes == 4 || Mes == 6 || Mes == 9 || Mes == 11)
					{
						if(Dia > 30)
						{
							fechaCorrecta = false;
						}
						else
						{
							fechaCorrecta = true;
						}
					}
					else
					{
						fechaCorrecta = true;
					}
				}
			}
			else
			{
				if(Mes == 4 || Mes == 6 || Mes == 9 || Mes == 11)
				{
					if(Dia > 30)
					{
						fechaCorrecta = false;
					}
					else
					{
						fechaCorrecta = true;
					}
				}
				else if(Mes == 2)
				{
					if(Dia > 28)
					{
						fechaCorrecta = false;
					}
					else
					{
						fechaCorrecta = true;
					}
				}
				else
				{
					fechaCorrecta = true;
				}
			}
		}
		
		return fechaCorrecta;
	}
	
}
