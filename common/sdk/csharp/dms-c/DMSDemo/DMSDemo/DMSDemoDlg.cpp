
// DMSDemoDlg.cpp : 实现文件
//

#include "stdafx.h"
#include "DMSDemo.h"
#include "DMSDemoDlg.h"
#include "afxdialogex.h"
#include <stdlib.h>

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CDMSDemoDlg 对话框
CDMSDemoDlg* CDMSDemoDlg::s_pDlg = NULL;

CDMSDemoDlg::CDMSDemoDlg(CWnd* pParent /*=NULL*/)
	: CDialogEx(CDMSDemoDlg::IDD, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CDMSDemoDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CDMSDemoDlg, CDialogEx)
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BTN_CONNECT, &CDMSDemoDlg::OnBnClickedBtnConnect)
	ON_BN_CLICKED(IDC_BTN_SUBSCRIBE, &CDMSDemoDlg::OnBnClickedBtnSubscribe)
	ON_BN_CLICKED(IDC_BTN_SEND, &CDMSDemoDlg::OnBnClickedBtnSend)
	ON_WM_CLOSE()
	ON_BN_CLICKED(IDC_BTN_UNSUBSCRIBE, &CDMSDemoDlg::OnBnClickedBtnUnsubscribe)
	ON_BN_CLICKED(IDC_BTN_CLEAR, &CDMSDemoDlg::OnBnClickedBtnClear)
	ON_MESSAGE(WM_DESTORY_DMS, &CDMSDemoDlg::OnDestoryDms)
	ON_BN_CLICKED(IDC_BTN_DISCONNECT, &CDMSDemoDlg::OnBnClickedBtnDisconnect)
END_MESSAGE_MAP()


// CDMSDemoDlg 消息处理程序

BOOL CDMSDemoDlg::OnInitDialog()
{
	CDialogEx::OnInitDialog();

	// 设置此对话框的图标。  当应用程序主窗口不是对话框时，框架将自动
	//  执行此操作
	SetIcon(m_hIcon, TRUE);			// 设置大图标
	SetIcon(m_hIcon, FALSE);		// 设置小图标

	ShowWindow(SW_SHOW);
	
	// TODO:  在此添加额外的初始化代码
	SetDlgItemTextW(IDC_EDIT_ADDRESS, CString("tcp://mqtt.dms.aodianyun.com:1883"));
	SetDlgItemTextW(IDC_EDIT_PUBKEY, CString("demo"));
	SetDlgItemTextW(IDC_EDIT_SUBKEY, CString("demo"));
	GUID guid;
	if (S_OK == ::CoCreateGuid(&guid)){
		CString clientId;
		clientId.Format(TEXT("%08X%04X%04x%02X%02X%02X%02X%02X%02X%02X%02X")
						, guid.Data1
						, guid.Data2
						, guid.Data3
						, guid.Data4[0], guid.Data4[1]
						, guid.Data4[2], guid.Data4[3], guid.Data4[4], guid.Data4[5]
						, guid.Data4[6], guid.Data4[7]);
		SetDlgItemTextW(IDC_EDIT_CLIENTID, clientId);
	}

	m_client = NULL;
	s_pDlg = this;
	Reset();

	GetDlgItem(IDC_BTN_CONNECT)->SetFocus();
	return FALSE;  // 除非将焦点设置到控件，否则返回 TRUE
}

// 如果向对话框添加最小化按钮，则需要下面的代码
//  来绘制该图标。  对于使用文档/视图模型的 MFC 应用程序，
//  这将由框架自动完成。

void CDMSDemoDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // 用于绘制的设备上下文

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// 使图标在工作区矩形中居中
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// 绘制图标
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialogEx::OnPaint();
	}
}

//当用户拖动最小化窗口时系统调用此函数取得光标
//显示。
HCURSOR CDMSDemoDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}

void CDMSDemoDlg::OnClose()
{
	// TODO:  在此添加消息处理程序代码和/或调用默认值
	CDialogEx::OnClose();
	this->DestroyWindow();
}

void CDMSDemoDlg::PostNcDestroy()
{
	// TODO:  在此添加专用代码和/或调用基类
	CDialogEx::PostNcDestroy();
	delete this;
}

CString CDMSDemoDlg::MultiByteToCString(const char * mb, size_t length)
{
	int charLen = MultiByteToWideChar(CP_UTF8, 0, mb, length, NULL, 0);
	WCHAR * wStr = new WCHAR[charLen + 1];
	if (wStr) {
		::MultiByteToWideChar(CP_UTF8, 0, mb, length, wStr, charLen);
		wStr[charLen] = TEXT('\0');
		CString str(wStr);
		delete wStr;
		return str;
	}
	return CString();
}

char* CDMSDemoDlg::CStringToMultiByte(CString str,size_t* pLength)
{
	int charLen = WideCharToMultiByte(CP_UTF8, 0, str, -1, NULL, 0, NULL, NULL);
	char * pszOut = new char[charLen];
	if (pszOut) {
		WideCharToMultiByte(CP_UTF8, 0, str, -1, pszOut, charLen, 0, 0);
	}
	if (pLength != NULL) {
		*pLength = charLen;
	}
	return pszOut;
}

void CDMSDemoDlg::AppendMessage(CString msg)
{
	CString str;
	s_pDlg->GetDlgItemTextW(IDC_EDIT_RECV, str);
	str = msg + TEXT("\r\n") + str;
	s_pDlg->SetDlgItemTextW(IDC_EDIT_RECV, str);
}
void CDMSDemoDlg::OnBnClickedBtnClear()
{
	// TODO:  在此添加控件通知处理程序代码
	SetDlgItemTextW(IDC_EDIT_RECV, CString());
}

afx_msg LRESULT CDMSDemoDlg::OnDestoryDms(WPARAM wParam, LPARAM lParam)
{
	if (m_client != NULL) {
		DMSAsync_destroy(&m_client);
	}
	return 0;
}

void CDMSDemoDlg::Reset()
{
	GetDlgItem(IDC_BTN_CONNECT)->EnableWindow(true);
	GetDlgItem(IDC_EDIT_PUBKEY)->EnableWindow(true);
	GetDlgItem(IDC_EDIT_SUBKEY)->EnableWindow(true);
	GetDlgItem(IDC_EDIT_ADDRESS)->EnableWindow(true);
	GetDlgItem(IDC_EDIT_CLIENTID)->EnableWindow(true);
	GetDlgItem(IDC_BTN_DISCONNECT)->EnableWindow(false);
	GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(false);
	GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(false);
	GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(false);
	GetDlgItem(IDC_CB_SEND_TOPIC)->EnableWindow(false);
	GetDlgItem(IDC_EDIT_PAYLOAD)->EnableWindow(false);
	GetDlgItem(IDC_BTN_SEND)->EnableWindow(false);
	((CComboBox *)s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC))->Clear();
}

int CDMSDemoDlg::messageArrived(void *context, char *topicName, int topicLen, DMSAsync_message *message)
{
	s_pDlg->AppendMessage(TEXT("Recv -> ") + MultiByteToCString(topicName, strlen(topicName)) + TEXT(":")
		+ MultiByteToCString((char *)message->payload, message->payloadlen));
	DMSAsync_freeMessage(&message);
	DMSAsync_free(topicName);
	s_pDlg->FlashWindowEx(FLASHW_ALL, 5, 500);
	return 1;
}
void CDMSDemoDlg::connectionLost(void* context, char* cause)
{
	s_pDlg->Reset();
	s_pDlg->AppendMessage(TEXT("Connection lost"));
	::PostMessage(s_pDlg->m_hWnd, WM_DESTORY_DMS, 0, 0);
}
void CDMSDemoDlg::deliveryComplete(void* context, DMSAsync_token token)
{
}
void CDMSDemoDlg::OnBnClickedBtnConnect()
{
	// TODO:  在此添加控件通知处理程序代码
	static char * s_pszPubKey = NULL;
	static char * s_pszSubKey = NULL;
	static char * s_pszAddress = NULL;
	static char * s_pszClientId = NULL;
	if (m_client == NULL)
	{
		if (s_pszAddress != NULL) { delete[] s_pszAddress; s_pszAddress = NULL; }
		if (s_pszClientId != NULL) { delete[] s_pszClientId; s_pszClientId = NULL; }
		CString address, clientId;
		this->GetDlgItemTextW(IDC_EDIT_ADDRESS, address);
		this->GetDlgItemTextW(IDC_EDIT_CLIENTID, clientId);
		if (address.GetLength()>0 && clientId.GetLength()>0){
			s_pszAddress = CStringToMultiByte(address);
			s_pszClientId = CStringToMultiByte(clientId);
		}
		if ((m_client = DMSAsync_create(s_pszAddress, s_pszClientId)) == NULL)
		{
			AfxMessageBox(TEXT("创建连接异常"));
			return;
		}
		DMSAsync_setCallbacks(m_client, NULL, CDMSDemoDlg::connectionLost, CDMSDemoDlg::messageArrived, CDMSDemoDlg::deliveryComplete);
		if (s_pszPubKey != NULL) { delete[] s_pszPubKey; s_pszPubKey = NULL; }
		if (s_pszSubKey != NULL) { delete[] s_pszSubKey; s_pszSubKey = NULL; }
		CString pubkey, subkey;
		this->GetDlgItemTextW(IDC_EDIT_PUBKEY, pubkey);
		this->GetDlgItemTextW(IDC_EDIT_SUBKEY, subkey);
		if (pubkey.GetLength()>0 && subkey.GetLength()>0){
			s_pszPubKey = CStringToMultiByte(pubkey);
			s_pszSubKey = CStringToMultiByte(subkey);
		}
		if (DMSAsync_connect(m_client, s_pszPubKey, s_pszSubKey, CDMSDemoDlg::onConnectSuccess, CDMSDemoDlg::onConnectFailure, NULL) != DMSASYNC_SUCCESS) {
			DMSAsync_destroy(&m_client);
		}
	}
}
void CDMSDemoDlg::onConnectSuccess(void* context, DMSAsync_successData* response)
{
	s_pDlg->GetDlgItem(IDC_BTN_CONNECT)->EnableWindow(false);
	s_pDlg->GetDlgItem(IDC_EDIT_PUBKEY)->EnableWindow(false);
	s_pDlg->GetDlgItem(IDC_EDIT_SUBKEY)->EnableWindow(false);
	s_pDlg->GetDlgItem(IDC_EDIT_ADDRESS)->EnableWindow(false);
	s_pDlg->GetDlgItem(IDC_EDIT_CLIENTID)->EnableWindow(false);
	s_pDlg->GetDlgItem(IDC_BTN_DISCONNECT)->EnableWindow(true);
	s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(true);
	s_pDlg->GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(true);
	s_pDlg->GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(true);
	s_pDlg->GetDlgItem(IDC_CB_SEND_TOPIC)->EnableWindow(true);
	s_pDlg->GetDlgItem(IDC_EDIT_PAYLOAD)->EnableWindow(true);
	s_pDlg->GetDlgItem(IDC_BTN_SEND)->EnableWindow(true);
	s_pDlg->AppendMessage(TEXT("Connected"));
}
void CDMSDemoDlg::onConnectFailure(void* context, DMSAsync_failureData* response)
{
	s_pDlg->Reset();
	s_pDlg->AppendMessage(TEXT("Fail to connect"));
	::PostMessage(s_pDlg->m_hWnd, WM_DESTORY_DMS, 0, 0);
}

void CDMSDemoDlg::OnBnClickedBtnDisconnect()
{
	// TODO:  在此添加控件通知处理程序代码
	if (m_client == NULL) return;
	DMSAsync_disconnectOptions opts = DisconOptsInit(CDMSDemoDlg::onDisconnectSuccess, CDMSDemoDlg::onDisconnectFailure, NULL);
	DMSAsync_disconnect(m_client, &opts);
}
void CDMSDemoDlg::onDisconnectSuccess(void* context, DMSAsync_successData* response)
{
	s_pDlg->Reset();
	s_pDlg->AppendMessage(TEXT("Disconnected"));
	::PostMessage(s_pDlg->m_hWnd, WM_DESTORY_DMS, 0, 0);
}
void CDMSDemoDlg::onDisconnectFailure(void* context, DMSAsync_failureData* response)
{
	s_pDlg->Reset();
	s_pDlg->AppendMessage(TEXT("Fail to disconnect"));
	::PostMessage(s_pDlg->m_hWnd, WM_DESTORY_DMS, 0, 0);
}

int CDMSDemoDlg::AddSubTopic(CString topic)
{
	CComboBox * pcb = (CComboBox *)s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC);
	int index = pcb->FindStringExact(0, topic);
	if (index != CB_ERR) {
		pcb->DeleteString(index);
	}
	pcb->InsertString(0, topic);
	pcb->SetCurSel(0);
	return index;
}
int CDMSDemoDlg::RemoveSubTopic(CString topic)
{
	CComboBox * pcb = (CComboBox *)s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC);
	int index = pcb->FindStringExact(0, topic);
	if (index != CB_ERR) {
		pcb->DeleteString(index);
	}
	return index;
}
void CDMSDemoDlg::OnBnClickedBtnSubscribe()
{
	// TODO:  在此添加控件通知处理程序代码
	CString topic;
	this->GetDlgItemTextW(IDC_CB_SUB_TOPIC, topic);
	if (m_client != NULL && topic.GetLength()>0)
	{
		CString* pTopic = new CString(topic);
		DMSAsync_responseOptions opts = RespOptsInit(CDMSDemoDlg::onSubscribeSuccess, CDMSDemoDlg::onSubscribeFailure, pTopic);
		CW2AEX<> convert(topic, CP_UTF8);
		char * lpszTopic = convert;
		if (DMSAsync_subscribe(m_client, lpszTopic, &opts) == DMSASYNC_SUCCESS) {
			GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(false);
			GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(false);
			GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(false);
		} else {
			delete pTopic;
		}
	}
}
void CDMSDemoDlg::onSubscribeSuccess(void* context, DMSAsync_successData* response)
{
	if (context) {
		CString* pTopic = (CString *)context;
		s_pDlg->AddSubTopic(*pTopic);
		s_pDlg->AppendMessage(TEXT("Subscribed : ") + *pTopic);
		s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(true);
		delete pTopic;
	}
}
void CDMSDemoDlg::onSubscribeFailure(void* context, DMSAsync_failureData* response)
{
	if (context) {
		CString* pTopic = (CString *)context;
		s_pDlg->AppendMessage(TEXT("Fail to subscribe : ") + *pTopic);
		s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(true);
		delete pTopic;
	}
}

void CDMSDemoDlg::OnBnClickedBtnUnsubscribe()
{
	// TODO:  在此添加控件通知处理程序代码
	CString topic;
	this->GetDlgItemTextW(IDC_CB_SUB_TOPIC, topic);
	if (m_client != NULL && topic.GetLength() > 0)
	{
		//USES_CONVERSION_EX;
		CString* pTopic = new CString(topic);
		DMSAsync_responseOptions opts = RespOptsInit(CDMSDemoDlg::onUnsubscribeSuccess, CDMSDemoDlg::onUnsubscribeFailure, pTopic);
		CW2AEX<> convert(topic, CP_UTF8);
		char * lpszTopic = convert;
		if (DMSAsync_unsubscribe(m_client, lpszTopic, &opts) == DMSASYNC_SUCCESS) {
			GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(false);
			GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(false);
			GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(false);
		} else {
			delete pTopic;
		}
	}
}
void CDMSDemoDlg::onUnsubscribeSuccess(void* context, DMSAsync_successData* response)
{
	if (context) {
		CString* pTopic = (CString *)context;
		s_pDlg->RemoveSubTopic(*pTopic);
		s_pDlg->AppendMessage(TEXT("Unsubscribed : ") + *pTopic);
		s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(true);
		delete pTopic;
	}
}
void CDMSDemoDlg::onUnsubscribeFailure(void* context, DMSAsync_failureData* response)
{
	if (context) {
		CString* pTopic = (CString *)context;
		s_pDlg->AppendMessage(TEXT("Fail To unsubscribe : ") + *pTopic);
		s_pDlg->GetDlgItem(IDC_CB_SUB_TOPIC)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_SUBSCRIBE)->EnableWindow(true);
		s_pDlg->GetDlgItem(IDC_BTN_UNSUBSCRIBE)->EnableWindow(true);
		delete pTopic;
	}
}

void CDMSDemoDlg::OnBnClickedBtnSend()
{
	// TODO:  在此添加控件通知处理程序代码
	CString topic,payload;
	this->GetDlgItemTextW(IDC_CB_SEND_TOPIC, topic);
	this->GetDlgItemTextW(IDC_EDIT_PAYLOAD, payload);
	if (m_client != NULL && topic.GetLength() > 0 && payload.GetLength()>0)
	{
		//USES_CONVERSION_EX;
		CString* pMsg = new CString(topic + TEXT(":") + payload);
		DMSAsync_responseOptions opts = RespOptsInit(CDMSDemoDlg::onSendSuccess, CDMSDemoDlg::onSendFailure, pMsg);
		CW2AEX<> topicCvt(topic, CP_UTF8);
		CW2AEX<> payloadCvt(payload, CP_UTF8);
		char * lpszTopic = topicCvt;
		char * lpszPayload = payloadCvt;
		if (DMSAsync_send(m_client, lpszTopic, strlen(lpszPayload), lpszPayload, &opts) == DMSASYNC_SUCCESS) {

			s_pDlg->GetDlgItem(IDC_BTN_SEND)->EnableWindow(false);
			CComboBox * pcb = (CComboBox *)s_pDlg->GetDlgItem(IDC_CB_SEND_TOPIC);
			int index = pcb->FindStringExact(0, topic);
			if (index != CB_ERR) {
				pcb->DeleteString(index);
			}
			pcb->InsertString(0, topic);
			pcb->SetCurSel(0);
		} else {
			delete pMsg;
		}
	}
}
void CDMSDemoDlg::onSendSuccess(void* context, DMSAsync_successData* response)
{
	if (context) {
		CString* pMsg = (CString *)context;
		s_pDlg->AppendMessage(TEXT("Send -> ") + *pMsg);
		s_pDlg->GetDlgItem(IDC_BTN_SEND)->EnableWindow(true);
		delete pMsg;
	}
}
void CDMSDemoDlg::onSendFailure(void* context, DMSAsync_failureData* response)
{
	if (context) {
		CString* pMsg = (CString *)context;
		s_pDlg->AppendMessage(TEXT("Fail to send -> ") + *pMsg);
		s_pDlg->GetDlgItem(IDC_BTN_SEND)->EnableWindow(true);
		delete pMsg;
	}
}







