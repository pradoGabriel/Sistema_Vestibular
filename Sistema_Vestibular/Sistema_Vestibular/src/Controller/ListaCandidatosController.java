package Controller;

import javax.swing.JOptionPane;

import Model.CandidatoModel;


public class ListaCandidatosController {

		private CandidatoModel inicio;

		public ListaCandidatosController(){
			inicio = null;
		}

		public void adicionaFinal(String nome, String rg, int cpf, int idade){
			if (inicio==null){
				CandidatoModel candidato = new CandidatoModel(nome, rg, cpf, idade);
				inicio = candidato;
			}
			else{
				CandidatoModel aux =inicio;
				while(aux.getProx()!=null){
					aux=aux.getProx();
				}
				CandidatoModel candidato =new CandidatoModel(nome, rg, cpf, idade);
				aux.setProx(candidato);
			}
		}

//	public void AdicionaInicio(int e){
//			CandidatoModel n=new CandidatoModel(e);
//			n.prox=inicio;
//			inicio=n;
//		}
//
//		public int RemoveFinal(){
//			int r=-1;
//			if (inicio==null){
//				System.out.println("Lista Vázia");
//			}
//			else{
//				if (inicio.prox==null){
//					r=inicio.dado;
//					inicio=null;
//				}
//				else{
//					CandidatoModel aux1=inicio;
//					CandidatoModel aux2=inicio;
//
//					while(aux1.prox!=null){
//						aux2=aux1;
//						aux1=aux1.prox;
//					}
//
//					r=aux1.dado;
//					aux2.prox=null;
//				}
//			}
//			return r;
//		}
//		
//		   public void escolhePosicao(int e, int pos){
//		        CandidatoModel CandidatoModelvo= new CandidatoModel(e);
//
//		        if(pos==1){  /*CONDIÇÃO DO COMEÇO DO MÉTODO MUDOU, TENDO EM VISTA QUE
//		             SEMPRE QUE A POSIÇÃO FOR 1, O ITEM SERÁ ADICIONADO CandidatoModel INICIO DA LISTA,
//		             NÃO IMPORTANDO SE A MESMA SE ENCONTRA VAZIA OU NÃO*/            
//		            AdicionaInicio(e);
//		        }else{       
//		            CandidatoModel aux=inicio;
//		            int count=1;
//		            
//		            while(aux.prox!=null && count<pos-1){
//		                aux=aux.prox;
//		                count++;
//		            }
//		            
//		            if(count==pos-1){  /*A CONSIÇÃO PARA SE SABER SE É POSSIVEL ADICIONAR
//		               O ITEM NA POSIÇÃO DESEJADA PASSOU A SER FORA DO LAÇO */
//		                CandidatoModelvo.prox=aux.prox;
//		                aux.prox=CandidatoModelvo;
//		            }else{
//		                System.out.println("Posição Inválida!");
//		            }            
//		        }
//		    }
//		   
//		   
//		    public int escolheRemove(int pos){
//		        int e=-1;
//		        int i=1;
//		        CandidatoModel aux=inicio;
//		        	        
//		        if(inicio==null){
//		            System.out.println("Lista Vazia!");
//		            return e;
//		        }    
//		        if(pos==1){// CandidatoModelVA CONDIÇÃO. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SERÁ O PRIMEIRO
//		            e=RemoveInicio();
//		            return e;
//		        }else{           
//		            while(aux.prox!=null){
//		                aux=aux.prox;
//		                i++;
//		            }
//		            if(pos>i || pos==0){
//		                System.out.println("Posição Invalida!");
//		                return e;
//		            }else if(pos==i){
//		                e=RemoveFinal();
//		                return e;
//		            }else{
//		                aux=inicio;
//		                CandidatoModel aux2=aux;
//		                
//		                while(pos>1){
//		                    aux2=aux;
//		                    aux=aux.prox;
//		                    pos--;
//		                }
//		                e=aux.dado;
//		                aux2.prox=aux.prox;
//		                return e;
//		            }
//		        }        
//		    }
//		 
//
//		public int RemoveInicio(){
//			int r=-1;
//			if (inicio==null){
//				JOptionPane.showMessageDialog(null,"Lista Vázia");
//			}
//			else{
//				r=inicio.dado;
//				inicio=inicio.prox;
//			}
//			return r;
//		}
//
//		public String percorre(){
//			CandidatoModel aux=inicio;
//			String r=" ";
//			while(aux!=null){
//				r=r+"\n"+aux.dado;
//				aux=aux.prox;
//			}
//			return r;
//		}
//	}

}
