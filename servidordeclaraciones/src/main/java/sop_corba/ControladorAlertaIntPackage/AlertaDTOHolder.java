package sop_corba.ControladorAlertaIntPackage;

/**
* sop_corba/ControladorAlertaIntPackage/AlertaDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* viernes 5 de agosto de 2022 06:46:06 PM COT
*/

public final class AlertaDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.ControladorAlertaIntPackage.AlertaDTO value = null;

  public AlertaDTOHolder ()
  {
  }

  public AlertaDTOHolder (sop_corba.ControladorAlertaIntPackage.AlertaDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.ControladorAlertaIntPackage.AlertaDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.ControladorAlertaIntPackage.AlertaDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.ControladorAlertaIntPackage.AlertaDTOHelper.type ();
  }

}
