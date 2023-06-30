import sys

sys.path.append('/root/software/NeoTCR-db/NeoTCRdb/view-service')
import json
import time

from thrift.protocol import TBinaryProtocol
from thrift.server import TServer
from thrift.transport import TSocket, TTransport

from view.api import ViewService
import paramiko
import pandas as pd


class ViewServiceHandler:

    def read_from(self, filename):
        print("filename:", filename)
        data = pd.read_table(filename, sep='\t')
        return data

    def getGene(self, x):
        if pd.isna(x):
            return '.'
        return str(x).split('*')[0]

    def getView(self, filename):
        print("view")
        print("filename:", filename)
        data = pd.read_table(filename, sep='\t')
        print("getview data", data.columns)
        data['cloneFraction'] = data['cloneFraction'].astype(float)
        data['cloneCount'] = data['cloneCount'].astype(float)
        data[['allVHitsWithScore', 'allDHitsWithScore', 'allJHitsWithScore']] = data[
            ['allVHitsWithScore', 'allDHitsWithScore', 'allJHitsWithScore']].applymap(self.getGene)


        tt = {}
        v_group = data[['allVHitsWithScore', 'cloneFraction']]
        if v_group.loc[0]['allVHitsWithScore'][2] == 'A':
            tt['type'] = 'a'
        else:
            tt['type'] = 'b'
        v_group = v_group.groupby('allVHitsWithScore').sum()
        temp = v_group.to_dict()['cloneFraction']
        v = list(temp.keys())
        freq = list(temp.values())

        tt['v_group'] = {
            'v': v,
            'freq': freq
        }

        d_group = data[['allDHitsWithScore', 'cloneFraction']]
        d_group = d_group.groupby('allDHitsWithScore').sum()
        temp = d_group.to_dict()['cloneFraction']
        d = list(temp.keys())
        freq = list(temp.values())
        # for key in temp:
        #     count.append(str(temp[key]))
        tt['d_group'] = {
            'd': d,
            'freq': freq
        }

        j_group = data[['allJHitsWithScore', 'cloneFraction']]
        j_group = j_group.groupby('allJHitsWithScore').sum()
        temp = j_group.to_dict()['cloneFraction']
        j = list(temp.keys())
        freq = list(temp.values())
        tt['j_group'] = {
            'j': j,
            'freq': freq
        }

        v_j_group = data[['allVHitsWithScore', 'allJHitsWithScore', 'cloneFraction']]
        v_j_group = v_j_group.groupby(['allVHitsWithScore', 'allJHitsWithScore']).sum()
        temp = v_j_group.to_dict()['cloneFraction']
        v = []
        j = []
        freq = list(temp.values())
        for key in temp:
            v.append(key[0])
            j.append(key[1])
            # count.append(str(temp[key]))
        tt['v_j_group'] = {
            'v': v,
            'j': j,
            'freq': freq
        }

        v_d_group = data[['allVHitsWithScore', 'allDHitsWithScore', 'cloneFraction']]
        v_d_group = v_d_group.groupby(['allVHitsWithScore', 'allDHitsWithScore']).sum()
        temp = v_d_group.to_dict()['cloneFraction']
        v = []
        d = []
        freq = list(temp.values())
        for key in temp:
            v.append(key[0])
            d.append(key[1])
        tt['v_d_group'] = {
            'v': v,
            'd': d,
            'freq': freq
        }

        d_j_group = data[['allDHitsWithScore', 'allJHitsWithScore', 'cloneFraction']]
        d_j_group = d_j_group.groupby(['allDHitsWithScore', 'allJHitsWithScore']).sum()
        temp = d_j_group.to_dict()['cloneFraction']
        # v=[]
        d = []
        j = []
        freq = list(temp.values())
        for key in temp:
            d.append(key[0])
            j.append(key[1])
        tt['d_j_group'] = {
            'd': d,
            'j': j,
            'freq': freq
        }

        # ====
        cdr3_group = data[['nSeqImputedCDR3', 'aaSeqImputedCDR3', 'cloneFraction']]
        cdr3_group = cdr3_group.groupby(['nSeqImputedCDR3', 'aaSeqImputedCDR3']).sum()
        temp = cdr3_group.to_dict()['cloneFraction']
        for key in temp:
            temp[key] = (temp[key], len(key[0]))
        dict_freq = sorted(temp.items(), key=lambda d: d[1][0], reverse=True)
        dict_len = sorted(temp.items(), key=lambda d: d[1][1], reverse=False)
        flag = 0
        len_freq = {}
        len_num = {}
        num = 0
        for item in dict_len:
            if item[1][1] > flag:
                flag = item[1][1]
                len_freq[flag] = item[1][0]
                len_num[flag] = num
                num += 1
            else:
                len_freq[flag] += item[1][0]
        temp1 = {}
        temp1['lengthNum'] = list(len_num.keys())
        nums = 20
        if (len(dict_freq) < nums):
            nums = 10
        if(len(dict_freq) < nums):
            nums = len(dict_freq)
        for i in range(nums):
            len_freq[dict_freq[i][1][1]] -= dict_freq[i][1][0]
            temp_list = [0] * num
            temp_list[len_num[dict_freq[i][1][1]]] = dict_freq[i][1][0]
            temp1[dict_freq[i][0][1]] = temp_list

        temp1['other'] = list(len_freq.values())
        tt['cdr3_group'] = temp1

        # ====
        freq = data[['cloneFraction', 'cloneCount']]
        counts = freq['cloneCount'].sum()
        s = freq.shape[0]
        c_freq = 0
        c = 0
        for item in freq['cloneFraction']:
            c_freq = c_freq + item
            c = c + 1
            if c_freq > 0.5:
                break

        d50 = c / s
        tt['diversity'] = {}
        reads = int(freq['cloneCount'].sum())
        tt['diversity']['reads'] = reads
        tt['diversity']['types'] = s
        tt['diversity']['d50'] = d50

        # # ====
        # ====
        cdr3_sun_group = data[['aaSeqImputedCDR3', 'cloneCount']]
        cdr3_sun_group = cdr3_sun_group.groupby(['aaSeqImputedCDR3']).sum()
        temp = cdr3_sun_group['cloneCount']
        sort_count = sorted(temp.items(), key=lambda d: d[1], reverse=False)
        count1 = 0
        count2 = 0
        ss = sort_count.__len__()
        clonetype = ss

        temp1 = {}
        for i in range(ss):
            if sort_count[i][1] == 1:
                count1 += 1
            elif sort_count[i][1] == 2:
                count2 += 1
            else:
                temp1['1'] = count1
                temp1['2'] = count2 * 2
                temp1['3+'] = reads - count1 - count2 * 2
                temp1['Q'] = []
                clonetype -= (count1 + count2)
                t1 = int(clonetype / 5)
                t2 = clonetype % 5
                t3 = 0 
                for j in range(t2):
                    t3 += sort_count[i][1]
                    i += 1
                    j += 1
                while i < ss:
                    t3 += sort_count[i][1]
                    t2 += 1
                    if t2 == t1:
                        temp1['Q'].append(t3)
                        t3 = 0
                        t2 = 0
                    i += 1
                break
        temp1['top'] = []
        temp1['top_num'] = []
        for i in range(5):
            temp1['top'].append(sort_count[ss - 1 - i][0])
            temp1['top_num'].append(sort_count[ss - 1 - i][1])
        tt['cdr3_sun'] = temp1
        tt_json = json.dumps(tt)
        return tt_json


if __name__ == '__main__':
    handler = ViewServiceHandler()
    processor = ViewService.Processor(handler)

    serverSocket = TSocket.TServerSocket(host='127.0.0.1', port=' ')
    transportFactory = TTransport.TFramedTransportFactory()
    protocolFactory = TBinaryProtocol.TBinaryProtocolFactory()

    thriftServer = TServer.TThreadedServer(processor, serverSocket, transportFactory, protocolFactory)


    print("Python Thrift Server start....")
    thriftServer.serve()
    print("Python Thrift Server exit")
