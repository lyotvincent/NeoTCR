import sys

sys.path.append('/root/software/NeoTCR-db/NeoTCRdb/analyse-service')
import time
import pandas as pd

import paramiko
import uuid
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from thrift.transport import TSocket, TTransport

from analyse.api import AnalyseService
import subprocess


# sys.path.append('../..')
# print(sys.path)

class AnalyseServiceHandler:

    def getAnalyse(self, filename1, filename2, outpath, chain):
        print("1")
        print(filename1, filename2, outpath)
        try:
            subprocess.run(['/root/analyse_method/analyse.sh', filename1, filename2, outpath, chain], stdout=subprocess.PIPE,
                           stderr=subprocess.PIPE, check=True)
        except subprocess.CalledProcessError as e:
            print(e)
            print("error")
            return False
        else:
            print("success")
            return True

    def getDNAAnalyse(self, filename1, filename2, outpath, chain):
        print(filename1, filename2, outpath)
        try:
            subprocess.run(['/root/analyse_method/analyse.sh', filename1, filename2, outpath, chain], stdout=subprocess.PIPE,
                           stderr=subprocess.PIPE, check=True)
        except subprocess.CalledProcessError as e:
            print(e)
            print("error")
            return False
        else:
            print("success")
            return True

    def getUMIAnalyse(self, filename1, filename2, umi, outpath, chain):
        print(filename1, filename2, outpath)
        try:
            subprocess.run(['/root/analyse_method/analyse.sh', filename1, filename2, outpath, chain, umi], stdout=subprocess.PIPE,
                           stderr=subprocess.PIPE, check=True)
        except subprocess.CalledProcessError as e:
            print(e)
            print("error")
            return False
        else:
            print("success")
            return True

    def getGene(self, x):
        if pd.isna(x):
            return '.'
        return str(x).split('*')[0]

    def conversion(self, fileName):
        print("filename:", fileName)
        data = pd.read_table(fileName, sep='\t')
        # print(data)
        data1 = pd.DataFrame()
        data1['count'] = data['cloneCount']
        data1['freq'] = data['cloneFraction']
        data1['cdr3nt'] = data['nSeqImputedCDR3']
        data1['cdr3aa'] = data['aaSeqImputedCDR3']
        data1['v'] = data['allVHitsWithScore']
        data1['d'] = data['allDHitsWithScore']
        data1['j'] = data['allJHitsWithScore']
        data1['c'] = data['allCHitsWithScore']
        data1['fr1'] = data['nSeqImputedFR1']
        data1['cdr1'] = data['nSeqImputedCDR1']
        data1['fr2'] = data['nSeqImputedFR2']
        data1['cdr2'] = data['nSeqImputedCDR2']
        data1['fr3'] = data['nSeqImputedFR3']
        data1['fr4'] = data['nSeqImputedFR4']
        data1[['v', 'd', 'j', 'c', 'fr1', 'cdr1', 'fr2', 'cdr2', 'fr3', 'fr4']] = data1[
            ['v', 'd', 'j', 'c', 'fr1', 'cdr1', 'fr2', 'cdr2', 'fr3', 'fr4']].applymap(self.getGene)
        return data1.to_json()

    def exampleTRA(self):
        try:
            subprocess.run(['/root/example/example_a.sh'], stdout=subprocess.PIPE,
                           stderr=subprocess.PIPE, check=True)
        except subprocess.CalledProcessError as e:
            print(e)
            print("error")
            return False
        else:
            print("success")
            return True


if __name__ == '__main__':
   
    handler = AnalyseServiceHandler()
    processor = AnalyseService.Processor(handler)
    serverSocket = TSocket.TServerSocket(host='127.0.0.1', port='9091')
    transportFactory = TTransport.TFramedTransportFactory()
    protocolFactory = TBinaryProtocol.TBinaryProtocolFactory()
    thriftServer = TServer.TThreadedServer(processor, serverSocket, transportFactory, protocolFactory)
    print("Python Thrift Server start....")
    thriftServer.serve()
    print("Python Thrift Server exit")
