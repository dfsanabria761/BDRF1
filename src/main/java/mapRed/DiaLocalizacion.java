package mapRed;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class DiaLocalizacion implements WritableComparable<DiaLocalizacion>{
	
	private int localizacion;
	private int dia;
		
	public DiaLocalizacion(int dia, int localizacion) {
			this.dia= dia;
			this.localizacion = localizacion;
	}
	
	public DiaLocalizacion() {
		
	}
	
	
	public int getDia() {
		return this.dia;
	}
	public int getLocalizacion() {
		return this.localizacion;
	}
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(dia);
		out.writeInt(localizacion);
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		dia=in.readInt();
		localizacion=in.readInt();
	}

	public int compareTo(DiaLocalizacion o) {
		// TODO Auto-generated method stub
		int pDia = this.dia;
		int pLocalizacion = this.localizacion;
		int nDia = o.dia;
		int nLocalizacion = o.localizacion;
		return (pDia<nDia ? -1: (pDia>nDia ? 1: 
											(pLocalizacion<nLocalizacion ? -1 : (pLocalizacion>nLocalizacion ? 1: 0)))); 
	}
	public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dia;
        result = prime * result + (int) (localizacion ^ (localizacion >>> 32));
        return result;
      }
}
